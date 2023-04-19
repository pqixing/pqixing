package com.pqixing.android.debug

import android.app.Activity
import android.app.ActivityOptions
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Rect
import android.hardware.bydauto.radar.AbsBYDAutoRadarListener
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.pqixing.android.App
import com.pqixing.android.R
import com.pqixing.android.byd.BYDAutoUtils
import com.pqixing.android.setting.DSetting

class DebugSetting : DSetting("调试开关") {

    override fun onUiCreate(
        activity: Activity,
        inflater: LayoutInflater,
        container: ViewGroup
    ): View {
        val view = inflater.inflate(R.layout.setting_debug, container, false)
        val result = view.findViewById<TextView>(R.id.tv_result)
        view.findViewById<View>(R.id.tv_send_name).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.baidu.com"))
//            val intent = Intent(activity,MainActivity::class.java)
                ?: return@setOnClickListener
            val opts = ActivityOptions.makeBasic().setLaunchBounds(Rect(100, 100, 300, 600))
            activity.startActivity(
                intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK), opts.toBundle()
            )

            result.text = activity.isInMultiWindowMode.toString()
        }
        view.findViewById<View>(R.id.tv_radar).setOnClickListener {
            result.text = BYDAutoUtils.getAllRadarDistance().joinToString()
        }
        view.findViewById<View>(R.id.tv_setting).setOnClickListener {
            onSettingClick(activity, result)
        }
        view.findViewById<CheckBox>(R.id.ib_air_control).setOnCheckedChangeListener { _, check ->
            result.text = BYDAutoUtils.setWirelessCharging(check).toString()
        }

        return view
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    private fun onSettingClick(ac: Activity, result: TextView) {
        val settins = arrayOf("后视镜状态", "空调", "后备箱", "获取温度", "打开倒车后视镜")
        AlertDialog.Builder(ac).setTitle("设置项目").setSingleChoiceItems(settins, 0) { d, i ->
            d.dismiss()

            kotlin.runCatching {
                val set = BYDAutoUtils.getSetting() ?: return@setSingleChoiceItems
                val ac = BYDAutoUtils.getAcControl() ?: return@setSingleChoiceItems
                val r = when (i) {
                    0 -> "autoSwitch=${set.autoExternalRearMirrorFollowUpSwitch} ; rearViewMirrorFlip=${set.rearViewMirrorFlip} ; rearMirrorFlip=${set.rearMirrorFlip} ; flipAngle=${set.leftViewMirrorFlipAngle} ,${set.rightViewMirrorFlipAngle} ; rearViewMirrorAutoFoldMode=${set.rearViewMirrorAutoFoldMode} ; "
                    1 -> "getAcStartState=${ac.acStartState} ; acWindLevel =${ac.acWindLevel} ;  acCompressorMode =${ac.acCompressorMode} ; acVentilationState =${ac.acVentilationState} ; "
                    2 -> "backDoorOpenedHeight=${set.backDoorOpenedHeight} ; backDoorElectricMode=${set.backDoorElectricMode} ; backDoorElectricModeOnlineState=${set.backDoorElectricModeOnlineState}"
                    3 -> "temperatureUnit=${ac.temperatureUnit} ; 车外温度=${ac.getTemprature(4)} ; 主驾温度=${
                        ac.getTemprature(
                            1
                        )
                    }; 副驾温度=${ac.getTemprature(2)}; 后排温度=${ac.getTemprature(3)}"
                    4 -> "setRearViewMirrorFlip=${set.setRearViewMirrorFlip(1)} ;"
                    else -> ""
                }.toString()
                result.text = "${settins.getOrNull(i)} : $r"
            }.onFailure {
                it.printStackTrace()
                result.text = it.message
                App.toast(it.message.toString())
            }
        }.show()
    }

}

class RadrListener(val textView: TextView) : AbsBYDAutoRadarListener() {
    override fun onRadarObstacleDistanceChanged(i: Int, i2: Int) {
        super.onRadarObstacleDistanceChanged(i, i2)
        setText("onRadarObstacleDistanceChanged : $i ; $i2")
    }

    override fun onRadarProbeStateChanged(i: Int, i2: Int) {
        super.onRadarProbeStateChanged(i, i2)
        setText("onRadarProbeStateChanged : $i ; $i2")
    }

    override fun onReverseRadarSwitchStateChanged(i: Int) {
        super.onReverseRadarSwitchStateChanged(i)
        setText("onReverseRadarSwitchStateChanged : $i")
    }

    fun setText(string: String) = textView.post {
        textView.text = string
    }
}