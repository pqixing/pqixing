package com.pqixing.bydauto.radar

import android.Manifest
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
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox
import com.pqixing.bydauto.App
import com.pqixing.bydauto.Const
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import kotlin.concurrent.thread

class RadarSetting : SettingImpl(R.layout.setting_radar) {
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

    private fun showPermissionDialog(activity: Context) {
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

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {

        val radar = viewHolder.findViewById<CheckBox>(R.id.cb_radar_open)
        radar.isChecked = Const.SP_OPEN_RADAR
        radar.setOnCheckedChangeListener { _, check ->
            if (check && viewHolder.context.checkSelfPermission(Manifest.permission.READ_LOGS) != PackageManager.PERMISSION_GRANTED) {
                showPermissionDialog(viewHolder.context)
                radar.isChecked = false
            } else {
                App.sp.edit().putBoolean(OPEN_RADAR, check).apply()
                onRadarWatch(viewHolder.context.applicationContext, check)
            }
        }

        viewHolder.findViewById<Button>(R.id.cb_radar_debug).setOnClickListener {
            closeFloatView(viewHolder.context)
            openFloatView(viewHolder.context, true, ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
            floatView?.resetBounds()
        }
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
        }.onFailure { App.log(null, it) }
    }

    fun closeFloatView(context: Context) {
        if (floatView == null) return
        kotlin.runCatching {
            val f = floatView
            floatView = null
            val wm = context.getSystemService(WindowManager::class.java)
            wm.removeView(f)
        }.onFailure { App.log(null, it) }
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
            App.log(null, it)
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
            App.log(null, it)
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