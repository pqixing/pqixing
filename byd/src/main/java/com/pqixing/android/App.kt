package com.pqixing.android

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.pqixing.android.byd.BYDAutoInstrumentUtils

class App : Application() {

    companion object {
        private lateinit var app: App

        fun log(msg: String?) {
            Log.i("appPqx", msg ?: "")
        }

        fun toast(msg: String) {
            log("toast : $msg")
            Toast.makeText(app, msg, Toast.LENGTH_SHORT).show()
        }

        private fun get(): App {
            return app
        }

        val sp: SharedPreferences
            get() = get().sp
        val mHandle: Handler
            get() = get().mHandle
        val mThread: Handler
            get() = get().mThread
    }

    val mHandle: Handler by lazy { Handler(Looper.getMainLooper()) }
    val mThread: Handler by lazy { Handler(HandlerThread("thread").also { it.start() }.looper) }

    val sp: SharedPreferences by lazy { getSharedPreferences("default", 0) }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        app = this
    }

    override fun onCreate() {
        super.onCreate()
        BYDAutoInstrumentUtils.init(this)
    }


}