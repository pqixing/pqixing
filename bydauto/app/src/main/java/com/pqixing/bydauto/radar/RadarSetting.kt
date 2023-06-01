package com.pqixing.bydauto.radar

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.PixelFormat
import android.net.Uri
import android.provider.Settings
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.setting.SettingImpl
import kotlin.concurrent.thread

class RadarSetting : SettingImpl("雷达测距") {
    companion object {
        const val OPEN_RADAR = "OPEN_RADAR"
    }

    private var serviceLive = false
    private var watch = false
    private val live: Boolean
        get() = watch && serviceLive

    private var pro: Process? = null
    private var floatView: RadarFloatView? = null
    private val reg = Regex(".*ActivityTaskManager.*(START|activityResumedForAcBar|Displayed|topComponentName).*")
    private val vReg = Regex(".*com\\.byd\\.avc.*AutoVideoActivity.*")
    override fun onBind(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val content = LinearLayout(activity)
        content.orientation = LinearLayout.HORIZONTAL
        content.gravity = Gravity.CENTER_VERTICAL


        val radar = CheckBox(activity)
        radar.gravity = Gravity.CENTER_VERTICAL
        radar.text = "开启"
        radar.isChecked = App.sp.getBoolean(OPEN_RADAR, false)
        radar.setPadding(20, 0, 0, 0)
        radar.setOnCheckedChangeListener { _, check ->
            if (check && activity.checkSelfPermission(Manifest.permission.READ_LOGS) != PackageManager.PERMISSION_GRANTED) {
                showPermissionDialog(activity)
                radar.isChecked = false
            } else {
                App.sp.edit().putBoolean(OPEN_RADAR, check).apply()
                onRadarWatch(activity.applicationContext, check)
            }
        }

        content.addView(radar)
        content.addView(View(activity), LinearLayout.LayoutParams(60, 1))

        val land = TextView(activity)
        land.text = "横屏调试"
        land.textSize = 18f
        land.setOnClickListener {
            closeFloatView(activity)
            openFloatView(activity, true, ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
            floatView?.resetBounds()
        }

        content.addView(land)
        content.addView(View(activity), LinearLayout.LayoutParams(60, 1))

        val portrait = TextView(activity)
        portrait.text = "竖屏调试"
        portrait.textSize = 18f
        portrait.setOnClickListener {
            closeFloatView(activity)
            openFloatView(activity, true, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            floatView?.resetBounds()
        }
        content.addView(portrait)
        return content
    }


    private fun showPermissionDialog(activity: Activity) {
        val cmd = "pm grant ${activity.packageName} ${Manifest.permission.READ_LOGS}"
        AlertDialog.Builder(activity)
            .setTitle("申请权限")
            .setMessage("请先通过adb命令授权日志权限: \n $cmd")
            .setPositiveButton("确定") { d, i ->
                activity.getSystemService(ClipboardManager::class.java)
                    .setPrimaryClip(ClipData.newPlainText("Label", cmd))
                App.toast("命令已复制到粘贴板")
            }.show()
    }

    override fun onServiceCreate(context: Context) {
        super.onServiceCreate(context)
        serviceLive = true
        if (App.sp.getBoolean(OPEN_RADAR, false)
            && context.checkSelfPermission(Manifest.permission.READ_LOGS) == PackageManager.PERMISSION_GRANTED
        ) {
            onRadarWatch(context, true)
        }
    }

    override fun onServiceDestroy(context: Context) {
        super.onServiceDestroy(context)
        serviceLive = false
        onRadarWatch(context, false)
    }

    fun openFloatView(context: Context, edit: Boolean = false, orientation: Int = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
        if (floatView?.isAttachedToWindow == true) return
        closeFloatView(context)
        if (!Settings.canDrawOverlays(context)) kotlin.runCatching {
            val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.parse("package:${context.packageName}"))
            context.startActivity(i)
            return
        }
        kotlin.runCatching {
            val wm = context.getSystemService(WindowManager::class.java)

            val floatView = RadarFloatView(context.applicationContext)
            wm.addView(floatView, layoutParams(edit, orientation))
            this.floatView = floatView
        }.onFailure { App.log(null,it) }
    }

    fun closeFloatView(context: Context) {
        if (floatView == null) return
        kotlin.runCatching {
            val f = floatView
            floatView = null
            val wm = context.getSystemService(WindowManager::class.java)
            wm.removeView(f)
        }.onFailure { App.log(null,it) }
    }


    private fun layoutParams(edit: Boolean = false, orientation: Int = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.MATCH_PARENT
            it.height = WindowManager.LayoutParams.MATCH_PARENT
            it.format = PixelFormat.RGBA_8888
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            if (!edit) {
                it.flags =
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            }
            it.gravity = Gravity.START or Gravity.TOP
            it.screenOrientation = orientation
            it.alpha = 1f
        }
    }

    private fun onRadarWatch(context: Context, watch: Boolean) {
        if (watch == this.watch) return

        kotlin.runCatching {
            this.watch = watch
            if (watch) watch(context) else {
                closeFloatView(context)
                pro?.destroy()
                pro = null
            }
        }.onFailure {
            App.log(null,it)
        }
    }

    private fun watch(context: Context) = thread {
        kotlin.runCatching {
            while (live) {
                //监听雷达距离和页面切换启动
                val pro =
                    Runtime.getRuntime().exec("logcat -T 0 -s ActivityTaskManager:I BYDAutoRadarDevice:D *:S")
//                    Runtime.getRuntime().exec("logcat -T 0")
                this.pro = pro
                pro.inputStream.bufferedReader().forEachLine { log ->
                    //雷达数据，解析并展示
                    if (live) {
                        parseString(log, context)
                    }
                }
                pro.destroy()
                this.pro = null
            }
        }.onFailure {
            App.log(null,it)
        }
    }

    private fun parseString(log: String, context: Context) {
        if (reg.matches(log)) App.mHandle.post {
            if (vReg.matches(log)) {
                openFloatView(context)
            } else {
                closeFloatView(context)
            }
        } else if (log.contains("getAllRadarDistance")) App.mHandle.post {
            floatView?.parseLog(log)
        }
    }
}