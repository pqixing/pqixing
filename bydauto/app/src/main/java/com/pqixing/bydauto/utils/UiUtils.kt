package com.pqixing.bydauto.utils

import android.Manifest
import android.accessibilityservice.AccessibilityService
import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.AppInfo


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
}