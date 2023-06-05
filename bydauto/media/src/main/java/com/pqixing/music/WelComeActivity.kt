package com.pqixing.music

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class WelComeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Toast.makeText(this, "指令转发启动", Toast.LENGTH_SHORT).show()
        finish()
    }
}