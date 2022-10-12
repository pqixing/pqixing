package com.pqixing.android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.pqixing.android.setting.SettingManager

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
}