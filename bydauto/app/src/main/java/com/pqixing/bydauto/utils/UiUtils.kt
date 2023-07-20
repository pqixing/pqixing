package com.pqixing.bydauto.utils

import android.Manifest
import android.accessibilityservice.AccessibilityService
import android.app.Activity
import android.app.DownloadManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import androidx.core.content.FileProvider
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.AppInfo
import com.pqixing.bydauto.service.CAService
import java.io.File


object UiUtils {

    private val floatViews: HashMap<String, View> = hashMapOf()

    fun getFloatView(tag: String): View? = floatViews[tag]

    fun reShowFloatView(tag: String, view: View, params: WindowManager.LayoutParams) {
        runCatching {
            closeFloatView(tag)
            val context = App.get()
            if (!Settings.canDrawOverlays(context)) kotlin.runCatching {
                val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .setData(Uri.parse("package:${context.packageName}"))
                context.startActivity(i)
            }

            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            wm.addView(view, params)
            floatViews[tag] = view

        }.onFailure {
            App.toast(it.message.toString())
        }
    }

    fun isShow(tag: String): Boolean {
        return floatViews[tag]?.isAttachedToWindow == true
    }

    fun showOrUpdateFloatView(tag: String, params: WindowManager.LayoutParams, getView: () -> View) {
        runCatching {
            if (isShow(tag)) {
                val context = App.get()
                val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                wm.updateViewLayout(floatViews[tag], params)
            } else {
                reShowFloatView(tag, getView(), params)
            }
        }
    }

    fun closeFloatView(tag: String) {
        runCatching {
            val view = floatViews.get(tag) ?: return
            val context = App.get()
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            wm.removeView(view)
            floatViews.remove(tag)
        }
    }

    fun checkSelfPermission(context: Context, permission: String): Boolean {
        return context.applicationContext.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun startService(context: Context, clazz: Class<out Service>) {
        val intent = Intent(context, clazz)
        if (Build.VERSION.SDK_INT >= 23) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }

    fun loadAppInfos(context: Context, pkgs: List<String>): List<AppInfo> {
        val pm = context.packageManager
        val curPkg = context.packageName

        return pkgs.filter { it != curPkg }.map {
            val info = pm.getApplicationInfo(it, PackageManager.GET_META_DATA)
            val name = pm.getApplicationLabel(info).toString()
            val icon = pm.getApplicationIcon(info)
            val intent = pm.getLaunchIntentForPackage(it)
            AppInfo(it, name, icon, intent)
        }
    }


    suspend fun tryLaunch(context: Context, pkg: String): Boolean {
        return kotlin.runCatching {
            val start: Intent = context.packageManager.getLaunchIntentForPackage(pkg) ?: return false
            start.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(start)
            App.log("checkLastPkg : start launch $pkg")
        }.onFailure {
            App.log(null, it)
        }.isSuccess
    }

    fun inSplitMode(context: Activity): Boolean {
        return false
    }

    fun hadGrantAll(context: Context): Boolean {
        return Settings.canDrawOverlays(context)
                && context.checkSelfPermission(Manifest.permission.READ_LOGS) == PackageManager.PERMISSION_GRANTED
    }

    fun getStatusBarH(context: Context): Int {
        val resources = context.resources
        val dimenId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return (if (dimenId > 0) {
            resources.getDimensionPixelSize(dimenId)
        } else {
            (resources.displayMetrics.density * 24).toInt()
        }) - 1
    }

    fun getNavigationBarH(context: Context): Int {
        val resources = context.resources
        val dimenId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return (if (dimenId > 0) {
            resources.getDimensionPixelSize(dimenId)
        } else {
            (resources.displayMetrics.density * 48).toInt()
        }) - 1
    }

    fun isAccessibilitySettingsOn(mContext: Context, clazz: Class<out AccessibilityService?>): Boolean {
        var accessibilityEnabled = 0
        val service = mContext.packageName + "/" + clazz.canonicalName
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                mContext.applicationContext.contentResolver,
                Settings.Secure.ACCESSIBILITY_ENABLED
            )
        } catch (e: Settings.SettingNotFoundException) {
            e.printStackTrace()
        }
        val mStringColonSplitter = TextUtils.SimpleStringSplitter(':')
        if (accessibilityEnabled == 1) {
            val settingValue = Settings.Secure.getString(
                mContext.applicationContext.contentResolver,
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
            )
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue)
                while (mStringColonSplitter.hasNext()) {
                    val accessibilityService = mStringColonSplitter.next()
                    if (accessibilityService.equals(service, ignoreCase = true)) {
                        return true
                    }
                }
            }
        }
        return false
    }


    //下载apk
    fun downloadAPK(
        context: Context,
        url: String,
        file: File,
        visible: Boolean = true,
        call: (success: Boolean) -> Unit
    ) {

        //获取DownloadManager
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        //创建下载任务
        val request = DownloadManager.Request(Uri.parse(url))
        //移动网络情况下是否允许漫游
        request.setAllowedOverRoaming(false)
        //在通知栏中显示，默认就是显示的,如果设置hidden，实测不会进行下载，设置VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION，在下载完成后，再一处下载即可
        request.setNotificationVisibility(if (visible) DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED else DownloadManager.Request.VISIBILITY_HIDDEN)
        request.setTitle(context.getString(R.string.download_title))
        request.setDescription("")
//        request.setVisibleInDownloadsUi(true)

        //7.0以上的系统适配
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            request.setRequiresDeviceIdle(false);
            request.setRequiresCharging(false);
        }
        //设置下载的路径
        request.setDestinationUri(Uri.fromFile(file))


        //将下载请求加入下载队列，加入下载队列后会给该任务返回一个long型的id，通过该id可以取消任务，重启任务、获取下载的文件等等
        val downloadId = downloadManager.enqueue(request)

        //注册广播接收者，监听下载状态
        val receiver = DownloadReceiver(context, downloadId, downloadManager, call)
        context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }

    /**
     * 安裝新版本升級包
     *
     * @return 无
     */
    fun installApk(context: Context, downFile: File) {
        // 为应用授权777权限
        grant(downFile)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        // 判断版本大于等于7.0
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // 给目标应用一个临时授权
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            FileProvider.getUriForFile(
                context,
                context.packageName + ".fileProvider",
                downFile
            )

        } else {
            Uri.fromFile(downFile)
        }
        //安装新的apk之前，删除本地的配置
        intent.setDataAndType(data, "application/vnd.android.package-archive")
        context.startActivity(intent)
    }

    /**
     * 授权：授予下载的apk 777权限，因为读写cache目录下的文件需要此权限
     *
     * @param updateFile 下载APK文件
     */
    private fun grant(updateFile: File) {
        val command = "chmod -R 777 " + updateFile.parent
        val runtime = Runtime.getRuntime()
        runtime.exec(command)
    }

    fun openUrl(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        context.startActivity(intent)
    }

    fun enableAccessibility(context: Context, enable: Boolean): Boolean {
        val strValue =
            if (enable) "${context.packageName}/${CAService::class.java.canonicalName}" else null
        Settings.Secure.putString(context.contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES, strValue)
        val intValue = if (enable) 1 else 0
        return Settings.Secure.putInt(context.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED, intValue)
    }
}


class DownloadReceiver(
    val context: Context,
    val downloadId: Long,
    val downloadManager: DownloadManager,
    val call: (success: Boolean) -> Unit
) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
        if (id != downloadId) {
            return
        }

        val query = DownloadManager.Query()
        //通过下载的id查找
        query.setFilterById(id)
        val cursor = downloadManager.query(query)
        if (cursor.moveToFirst()) {
            when (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))) {
                DownloadManager.STATUS_SUCCESSFUL -> onDownloadComplete(cursor, true)
                DownloadManager.STATUS_FAILED -> onDownloadComplete(cursor, false)
            }
        }

    }

    private fun onDownloadComplete(cursor: Cursor, success: Boolean) {
        call(success)
        cursor.close()
        context.unregisterReceiver(this)
        //在remove之前，下载成功的文件已经被重命名，所以不用担心删除的问题
        kotlin.runCatching { downloadManager.remove(downloadId) }
    }

}
