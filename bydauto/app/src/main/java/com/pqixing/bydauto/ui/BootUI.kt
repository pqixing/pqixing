package com.pqixing.bydauto.ui

import android.content.Intent
import android.os.Bundle
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.SettingManager

class BootUI : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (SettingManager.prepare) {
            startService(Intent(this, MainService::class.java))
        } else {
            startActivity(Intent(this, MainUI::class.java))
        }
        finish()
    }
}


