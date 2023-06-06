package com.pqixing.bydauto.setting.item

import android.Manifest
import android.app.ActivityManager
import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.LogcatManager
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.RadarFloatView

class RadarDistance : SettingImpl(R.layout.setting_radar), LogcatManager.LogCatCallBack {
    companion object {
        const val FLOAT_TAG_RADAR = "FLOAT_TAG_RADAR"
    }

    private val regAutoVideo = Regex(".*com\\.byd\\.avc.*AutoVideoActivity.*")

    private fun showPermissionDialog(activity: Context) {
        val cmd = "pm grant ${activity.packageName} ${Manifest.permission.READ_LOGS}"
        AlertDialog.Builder(activity).setTitle("申请权限").setMessage("请先通过adb命令授权日志权限: \n $cmd").setPositiveButton("确定") { d, i ->
            activity.getSystemService(ClipboardManager::class.java).setPrimaryClip(ClipData.newPlainText("Label", cmd))
            App.toast("命令已复制到粘贴板")
        }.show()
    }

    override fun onServiceCreate(context: Context) {
        super.onServiceCreate(context)
        if (Const.SP_OPEN_RADAR) {
            LogcatManager.addCallBack(this)
        }
    }

    override fun onServiceDestroy(context: Context) {
        super.onServiceDestroy(context)
        LogcatManager.removeCallBack(this)
    }

    override fun getNameId(): Int = R.string.setting_name_radar

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {

        val radar = viewHolder.findViewById<CheckBox>(R.id.cb_radar_open)
        radar.isChecked = Const.SP_OPEN_RADAR
        radar.setOnCheckedChangeListener { _, check ->
            if (check && !UiUtils.checkSelfPermission(viewHolder.context, Manifest.permission.READ_LOGS)) {
                showPermissionDialog(viewHolder.context)
                radar.isChecked = false
            } else {
                Const.SP_OPEN_RADAR = check
                LogcatManager.removeCallBack(this)

                if (check) {
                    LogcatManager.addCallBack(this)
                    LogcatManager.close()
                    LogcatManager.start()
                }
            }
        }

        viewHolder.findViewById<Button>(R.id.cb_radar_debug).setOnClickListener {
            UiUtils.showFloatView(
                FLOAT_TAG_RADAR, RadarFloatView(viewHolder.context.applicationContext).also { it.resetBounds() }, layoutParams(true)
            )
        }
    }

    private fun layoutParams(edit: Boolean = false, orientation: Int = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.MATCH_PARENT
            it.height = WindowManager.LayoutParams.MATCH_PARENT
            it.format = PixelFormat.RGBA_8888
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            if (!edit) {
                it.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            }
            it.gravity = Gravity.START or Gravity.TOP
            it.screenOrientation = orientation
            it.alpha = 1f
        }
    }

    override fun getFilterRex(): String {
        return ".*ActivityTaskManager.*(START|activityResumedForAcBar|Displayed|topComponentName).*"
    }

    override fun onReceiveLog(line: String) {
        val isAutoVideo = regAutoVideo.matches(line)
        if (isAutoVideo && UiUtils.getFloatView(FLOAT_TAG_RADAR)?.isAttachedToWindow != true) {
            UiUtils.showFloatView(FLOAT_TAG_RADAR, RadarFloatView(App.get()), layoutParams())
        }
        if (!isAutoVideo) {
            UiUtils.closeFloatView(FLOAT_TAG_RADAR)
        }
    }
}