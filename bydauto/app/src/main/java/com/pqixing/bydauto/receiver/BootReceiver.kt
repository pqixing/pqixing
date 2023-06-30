package com.pqixing.bydauto.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pqixing.bydauto.App
import com.pqixing.bydauto.ui.MainUI
import java.text.DateFormat
import java.util.*


class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val receiveStr = "onReceive: ${intent.action} -> ${DateFormat.getDateTimeInstance().format(Date())}"
        App.log(receiveStr)
        kotlin.runCatching {
            context.startActivity(
                Intent(context, MainUI::class.java).putExtra("from", "boot")
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }

}