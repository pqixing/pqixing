package com.pqixing.bydauto.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.CarInfo
import com.pqixing.bydauto.model.MusicInfo
import com.pqixing.bydauto.utils.SettingManager
import com.pqixing.bydauto.utils.UiManager

class MainService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    private val carInfo = CarInfo()
    private val musicInfo = MusicInfo()

    override fun onCreate() {
        super.onCreate()
        musicInfo.onCreate(this)
        carInfo.onCreate(this)
        SettingManager.updateCurSettings(this)
        App.mThread.post { UiManager.initApps() }
    }


    override fun onDestroy() {
        super.onDestroy()
        musicInfo.onDestroy(this)
        carInfo.onDestroy(this)
        SettingManager.getSettings(this).forEach { it.onDestroy(this) }
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingPermission: ")
    }
}