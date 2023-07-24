package com.pqixing.bydauto.ui

import android.content.Intent
import android.os.Bundle

class EmptyUI : BaseActivity() {

    companion object {
        var lastCall: ((intent: Intent?) -> Unit)? = null
        var lastIntent: Intent? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent == null) {
            finish()
        }
        startActivityForResult(lastIntent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        lastCall?.invoke(data)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        lastCall = null
        lastIntent = null
    }
}


