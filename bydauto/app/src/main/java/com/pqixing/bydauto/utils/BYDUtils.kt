package com.pqixing.bydauto.utils

import android.content.Intent
import com.pqixing.bydauto.App

object BYDUtils {

    fun sendDiCmd(cmd: String) {
        "send di cmd $cmd".toast()
        val intent = Intent("com.intent.action.Voice_self_From_Screen")
        intent.putExtra("Scrren_ViewText", cmd)
        App.get().sendBroadcast(intent)
    }

    fun setWirelessCharging(charge: Boolean) {
        sendDiCmd(if (charge) "开启无线充电" else "关闭无线充电")
    }
}