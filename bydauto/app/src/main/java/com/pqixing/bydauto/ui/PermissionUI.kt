package com.pqixing.bydauto.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.CheckBox
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.CarAccessibilityService
import com.pqixing.bydauto.utils.AdbClient
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.launch

class PermissionUI : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (UiUtils.hadGrantAll(this)) {
            startActivity(Intent(this, MainUI::class.java))
            finish()
            return
        }
        setContentView(R.layout.main_activity_permission)
        updateUI(true)
    }

    override fun onStart() {
        super.onStart()
        updateUI(false)
    }

    private fun updateUI(setClick: Boolean) {
        val cbFloat = findViewById<CheckBox>(R.id.cb_float)
        val cbAccessibility = findViewById<CheckBox>(R.id.cb_accessibility)
        val cbReadLogs = findViewById<CheckBox>(R.id.cb_read_logs)
        cbFloat.isChecked = Settings.canDrawOverlays(this)
        cbAccessibility.isChecked = CarAccessibilityService.connect
        cbReadLogs.isChecked = checkSelfPermission(Manifest.permission.READ_LOGS) == PackageManager.PERMISSION_GRANTED
        if (setClick) {
            cbFloat.setOnClickListener {
                val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .setData(Uri.parse("package:${packageName}"))
                startActivity(i)
            }
            cbAccessibility.setOnClickListener {
                val i = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(i)
            }
            cbReadLogs.setOnClickListener {
                App.uiScope.launch {
                    AdbClient.getClient().runCmd("pm grant $packageName ${Manifest.permission.READ_LOGS}")
                }
            }
        }
    }
}


