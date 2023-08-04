package com.pqixing.bydauto.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.item.WireChargeItem
import com.pqixing.bydauto.ui.BootUI
import com.pqixing.bydauto.utils.BYDAutoUtils


class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        kotlin.runCatching {
            context.startActivity(Intent(context, BootUI::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            //设置无线充电
            when (Const.SP_CHARGE_TYPE) {
                WireChargeItem.CHARGE_TYPE_OPEN -> BYDAutoUtils.setWirelessCharging(true)
                WireChargeItem.CHARGE_TYPE_CLOSE -> BYDAutoUtils.setWirelessCharging(false)
                else -> ""
            }
        }
    }
}