package com.pqixing.bydauto.boot

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pqixing.bydauto.App
import com.pqixing.bydauto.MainActivity
import java.text.DateFormat
import java.util.Date


class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val receiveStr = "onReceive: ${intent.action} -> ${DateFormat.getDateTimeInstance().format(Date())}"
        App.log(receiveStr)
        if (App.sp.getBoolean(BootSetting.IS_BOOT, false)) kotlin.runCatching {
            context.startActivity(
                Intent(context, MainActivity::class.java).putExtra("from", "boot")
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }

}