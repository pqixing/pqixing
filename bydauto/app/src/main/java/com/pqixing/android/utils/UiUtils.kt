package com.pqixing.android.utils

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build

object UiUtils {

    fun startService(context: Context, clazz: Class<out Service>) {
        val intent = Intent(context, clazz)
        if (Build.VERSION.SDK_INT >= 23) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }
}