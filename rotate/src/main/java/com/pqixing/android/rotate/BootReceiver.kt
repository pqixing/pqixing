package com.pqixing.android.rotate

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import java.text.DateFormat
import java.util.*

class BootReceiver : BroadcastReceiver() {
    companion object {
        const val TAG = "BootReceiver"
        var isBoot = false
    }

    override fun onReceive(context: Context, intent: Intent) {
        val receiveStr = "onReceive: ${intent.action} -> ${DateFormat.getDateTimeInstance().format(Date())}"
        Log.w(TAG, receiveStr)
        if (isBoot) return
        if (!RotateActivity.getSp(context).getBoolean("boot", false)) return
        isBoot = if (Settings.canDrawOverlays(context)) {
            tryStartService(context)
        } else {
            tryStartActivity(context)
        }
        Toast.makeText(context, if (isBoot) "旋转服务启动成功" else "旋转服务启动失败", Toast.LENGTH_SHORT).show()
    }

    private fun tryStartActivity(context: Context): Boolean {
        Log.i(TAG, "tryStartActivity: ")
        return kotlin.runCatching {
            val i = Intent(context, RotateActivity::class.java)
            i.putExtra("fromBoot", true)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }.onFailure {
            Log.w(TAG, "tryStartActivity: ", it)
            Toast.makeText(context, "tryStartActivity fail : ${it.message}", Toast.LENGTH_LONG).show()
        }.isSuccess
    }

    private fun tryStartService(context: Context): Boolean {
        return kotlin.runCatching {
            Log.i(TAG, "tryStartService: ")
            val i = Intent(context, RotateService::class.java)
            context.startService(i)
        }.onFailure {
            Log.w(TAG, "tryStartService: ", it)
        }.isSuccess || tryStartActivity(context)
    }
}