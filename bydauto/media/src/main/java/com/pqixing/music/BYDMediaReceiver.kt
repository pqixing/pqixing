package com.pqixing.android.music

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast


class BYDMediaReceiver : BroadcastReceiver() {
    companion object {
        var pkg = ""
    }

    override fun onReceive(context: Context, intent: Intent?) {
        val aciton = intent?.action ?: return
        if (pkg.isEmpty()) {
            //支持小迪语音的软件
            pkg = context.packageManager.queryBroadcastReceivers(
                Intent("pqx.intent.action.MEDIA"), PackageManager.GET_META_DATA
            ).map { it.activityInfo.packageName }.firstOrNull() ?: return
        }

        val newIntent = Intent(aciton)
        newIntent.flags = intent.flags
        newIntent.putExtras(intent)
        newIntent.setPackage(pkg)
        newIntent.putExtra("pkgName", pkg)
        newIntent.putExtra("HAD_BEEN_RESEND_TO", context.packageName)
        context.sendBroadcast(newIntent)
        Toast.makeText(context, "send $aciton to $pkg", Toast.LENGTH_SHORT).show()
    }

}