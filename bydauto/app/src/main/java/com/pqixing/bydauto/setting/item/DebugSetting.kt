package com.pqixing.bydauto.setting.item

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.view.ViewGroup
import android.widget.TextView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.BYDAutoUtils

class DebugSetting : SettingImpl(R.layout.setting_debug) {
    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val view = viewHolder.itemView
        val result = view.findViewById<TextView>(R.id.tv_result)

        val group = view.findViewById<ViewGroup>(R.id.gd_group)
        for (i in 0 until group.childCount) {
            group.getChildAt(i).setOnClickListener { onChildCick(it.id, result) }
        }
    }

    private fun onChildCick(id: Int, result: TextView) {
        result.text = runCatching {
            when (id) {
                R.id.tv_radar -> BYDAutoUtils.getAllRadarDistance().joinToString()
                R.id.tv_send_name -> BYDAutoUtils.getInstrument().sendMusicName("发送名称测试")
                R.id.tv_wirless_charging -> BYDAutoUtils.setWirelessCharging(false).toString()
                R.id.tv_split -> {
                    val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.baidu.com"))
                    val opts = ActivityOptions.makeBasic().setLaunchBounds(Rect(100, 100, 300, 600))
                    result.context.startActivity(
                        intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK), opts.toBundle()
                    )
                    (result.context as Activity).isInMultiWindowMode
                }

                R.id.tv_air -> {
                    val ac = BYDAutoUtils.getAcControl()
                    "getAcStartState=${ac.acStartState} ; acWindLevel =${ac.acWindLevel} ;  acCompressorMode =${ac.acCompressorMode} ; acVentilationState =${ac.acVentilationState} ; "
                }

                R.id.tv_temprature -> {
                    val ac = BYDAutoUtils.getAcControl()
                    "单位=${ac.temperatureUnit} ; 车外=${ac.getTemprature(4)} ; 主驾=${ac.getTemprature(1)}; 副驾=${ac.getTemprature(2)}; 后排=${
                        ac.getTemprature(
                            3
                        )
                    }"
                }

                else -> null
            }.toString()
        }.getOrElse { it.message }
    }

    override fun getNameId(): Int {
        return R.string.setting_name_adb
    }

}