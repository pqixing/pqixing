package com.pqixing.bydauto

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.pqixing.bydauto.setting.SettingManager

class MainService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        SettingManager.settings.forEach { it.onServiceCreate(this) }
    }

    override fun onDestroy() {
        super.onDestroy()
        SettingManager.settings.forEach { it.onServiceDestroy(this) }
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingOrSelfPermission: $permission", )
        Toast.makeText(this, "enforceCallingOrSelfPermission", Toast.LENGTH_SHORT).show()
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingPermission: ", )
        Toast.makeText(this, "enforceCallingPermission $permission", Toast.LENGTH_SHORT).show()
    }
}