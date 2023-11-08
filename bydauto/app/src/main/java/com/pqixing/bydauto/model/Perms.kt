package com.pqixing.bydauto.model

import android.Manifest
import android.content.pm.PackageManager
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.app

class Perms {
    var float: Boolean = false
    var log: Boolean = false
    var notify: Boolean = false
    var secure: Boolean = false

    init {
        updatePermission()
    }

    fun all(): Boolean = float && log && notify && secure
    fun updatePermission() {
        float = Settings.canDrawOverlays(App.get())
        log = ContextCompat.checkSelfPermission(App.get(), Manifest.permission.READ_LOGS) ==
                PackageManager.PERMISSION_GRANTED
        notify = NotificationManagerCompat.getEnabledListenerPackages(app).contains(app.packageName)

        secure =
            ContextCompat.checkSelfPermission(App.get(), Manifest.permission.WRITE_SECURE_SETTINGS) ==
                    PackageManager.PERMISSION_GRANTED
    }
}