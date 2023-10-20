package com.pqixing.bydauto.setting.item

import android.content.Context
import android.widget.Button
import android.widget.CheckBox
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.RadarFloatView

class RadarItem : SettingImpl(R.layout.setting_radar), UiManager.IActivityLife {
    companion object {
        const val FLOAT_TAG_RADAR = "FLOAT_TAG_RADAR"
    }

    override fun isShow(context: Context): Boolean {
        return PermType.ReadLogs.enable()
    }

    private val RADAR_ACTIVITY = "com.byd.avc.AutoVideoActivity"
    private val RADAR_PKG = "com.byd.avc"


    override fun onCreate(context: Context) {
        super.onCreate(context)
        if (Const.SP_OPEN_RADAR) {
            UiManager.addCallBack(this)
        }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        UiManager.removeCallBack(this)
    }

    override fun getNameId(): Int = R.string.setting_name_radar

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {

        val radar = viewHolder.findViewById<CheckBox>(R.id.cb_radar_open)
        radar.isChecked = Const.SP_OPEN_RADAR
        radar.setOnCheckedChangeListener { _, check ->
            Const.SP_OPEN_RADAR = check
            UiManager.removeCallBack(this)
            if (check) {
                UiManager.addCallBack(this)
            }
        }

        viewHolder.findViewById<Button>(R.id.cb_radar_debug).setOnClickListener {
            UiUtils.showOrUpdate(FLOAT_TAG_RADAR) {
                RadarFloatView(viewHolder.context.applicationContext).also {
                    it.resetBounds()
                }
            }
        }
    }

    override fun onPkgResume(pkg: String) {
        val isAutoVideo = RADAR_PKG == pkg
        if (isAutoVideo && !UiUtils.isShow(FLOAT_TAG_RADAR)) {
            UiUtils.showOrUpdate(FLOAT_TAG_RADAR) {
                RadarFloatView(App.get())
            }
        }
        if (!isAutoVideo) {
            UiUtils.closeFloatView(FLOAT_TAG_RADAR)
        }
    }
}