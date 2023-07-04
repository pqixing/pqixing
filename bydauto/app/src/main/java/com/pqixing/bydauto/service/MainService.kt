package com.pqixing.bydauto.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.pqixing.bydauto.utils.SettingManager

class MainService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        SettingManager.updateCurSettings(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        SettingManager.getSettings(this).forEach { it.onDestroy(this) }
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingPermission: ")
    }
}