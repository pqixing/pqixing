package com.pqixing.bydauto.ui

import android.content.Intent
import android.os.Bundle
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.MainService

class BootUI : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        if (!PermType.enableAll()) {
            startActivity(Intent(this, MainUI::class.java))
        }
        finish()
    }
}


