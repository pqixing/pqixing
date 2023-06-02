package com.pqixing.bydauto.utils

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import com.pqixing.bydauto.model.AppInfo

object UiUtils {

    fun startService(context: Context, clazz: Class<out Service>) {
        val intent = Intent(context, clazz)
        if (Build.VERSION.SDK_INT >= 23) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }

    fun loadAppInfos(context: Context, pkgs: List<String>): List<AppInfo> {
        val pm = context.packageManager
        val curPkg = context.packageName

        return pkgs.filter { it != curPkg }.map {
            val info = pm.getApplicationInfo(it, PackageManager.GET_META_DATA)
            val name = pm.getApplicationLabel(info).toString()
            val icon = pm.getApplicationIcon(info)
            val intent = pm.getLaunchIntentForPackage(it)
            AppInfo(it, name, icon, intent)
        }
    }
}