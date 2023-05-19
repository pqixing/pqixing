package com.pqixing.bydauto

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.cgutman.androidremotedebugger.ConnectActivity
import com.yhao.floatwindow.FloatWindow

class EnterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,ConnectActivity::class.java))
    }
}