package com.pqixing.bydauto.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pqixing.bydauto.setting.item.BootItem
import com.pqixing.bydauto.ui.BootUI


class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        BootItem.boot = true
        kotlin.runCatching {
            context.startActivity(Intent(context, BootUI::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }
}