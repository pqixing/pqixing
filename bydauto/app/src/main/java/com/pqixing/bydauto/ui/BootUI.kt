package com.pqixing.bydauto.ui

import android.content.Intent
import android.os.Bundle
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.MainService

class BootUI : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        if (!PermType.hasAllPermission()) {
            startActivity(Intent(this, MainUI::class.java))
        }
        finish()
    }
//
//    override fun onStart() {
//        super.onStart()
//        updateUI(false)
//    }
//
//    private fun updateUI(setClick: Boolean) {
//        val cbFloat = findViewById<CheckBox>(R.id.cb_float)
//        val cbAccessibility = findViewById<CheckBox>(R.id.cb_accessibility)
//        val cbReadLogs = findViewById<CheckBox>(R.id.cb_read_logs)
//        cbFloat.isChecked = Settings.canDrawOverlays(this)
//        cbAccessibility.isChecked = CarAccessibilityService.connect
//        cbReadLogs.isChecked = checkSelfPermission(Manifest.permission.READ_LOGS) == PackageManager.PERMISSION_GRANTED
//        if (setClick) {
//            cbFloat.setOnClickListener {
//                val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
//                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    .setData(Uri.parse("package:${packageName}"))
//                startActivity(i)
//            }
//            cbAccessibility.setOnClickListener {
//                val i = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
//                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(i)
//            }
//            cbReadLogs.setOnClickListener {
//                App.uiScope.launch {
//                    AdbClient.getClient().runSync("pm grant $packageName ${Manifest.permission.READ_LOGS}")
//                }
//            }
//        }
//    }
}


