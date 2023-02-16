package com.pqixing.android

import android.app.Activity
import android.app.AlertDialog
import android.hardware.bydauto.setting.BYDAutoSettingDevice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.pqixing.android.byd.BYDAutoInstrumentUtils
import com.pqixing.android.setting.DSetting

class DebugSetting : DSetting("调试开关") {

    override fun onUiCreate(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.setting_debug, container, false)
        val result = view.findViewById<TextView>(R.id.tv_result)
        view.findViewById<View>(R.id.tv_send_name).setOnClickListener {
            result.text = BYDAutoInstrumentUtils.sendMusicName("名称设置新").toString()
        }
        view.findViewById<View>(R.id.tv_radar).setOnClickListener {
            result.text = BYDAutoInstrumentUtils.getAllRadarDistance().joinToString()
        }
        view.findViewById<View>(R.id.tv_setting).setOnClickListener {
            onSettingClick(activity, result)
        }
        view.findViewById<CheckBox>(R.id.ib_air_control).setOnCheckedChangeListener { _, check ->
            result.text = BYDAutoInstrumentUtils.setWirelessCharging(if (check) 1 else 0).toString()
        }

        return view
    }

    private fun onSettingClick(ac: Activity, result: TextView) {
        val settins = arrayOf("后视镜状态", "空调", "后备箱")
        AlertDialog.Builder(ac).setTitle("设置项目").setSingleChoiceItems(settins, 0) { d, i ->
            d.dismiss()

            kotlin.runCatching {
                val instance = BYDAutoSettingDevice.getInstance(ac) ?: return@setSingleChoiceItems
                val r = when (i) {
                    0 -> "autoExternalRearMirrorFollowUpSwitch=${instance.autoExternalRearMirrorFollowUpSwitch} ; rearMirrorFlip=${instance.rearMirrorFlip} ; flipAngle=${instance.leftViewMirrorFlipAngle} ,${instance.rightViewMirrorFlipAngle} ; rearViewMirrorAutoFoldMode=${instance.rearViewMirrorAutoFoldMode} ; rearViewMirrorFlip=${instance.rearViewMirrorFlip} ;"
                    1 -> "acAutoWindLevel=${instance.acAutoWindLevel} ; acAutoAir =${instance.acAutoAir}"
                    2 -> "backDoorOpenedHeight=${instance.backDoorOpenedHeight} ; backDoorElectricMode=${instance.backDoorElectricMode} ; backDoorElectricModeOnlineState=${instance.backDoorElectricModeOnlineState}"
                    else -> ""
                }.toString()
                result.text = "${settins.getOrNull(i)} : $r"
            }
        }.show()
    }

}