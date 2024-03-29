package com.pqixing.bydauto

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.UiManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import java.io.File

class App : Application() {

    companion object {
        private lateinit var app: App
        const val TAG = "car_tool"

        fun log(msg: String?, thow: Throwable? = null, index: Int = 4) {
            val stactTrace = Thread.currentThread().stackTrace.getOrNull(index)
            val msg =
                if (stactTrace == null) msg else "${stactTrace.className.substringAfterLast(".")}[${stactTrace.lineNumber}].${stactTrace.methodName} : $msg"
            if (thow != null) {
                Log.w(TAG, msg ?: "", thow)
            } else {
                Log.i(TAG, msg ?: "")
            }
        }

        fun toast(msg: String) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                log(msg, null, 6)
                Toast.makeText(app, msg, Toast.LENGTH_SHORT).show()
            } else get().mHandle.post { toast(msg) }
        }

        fun get(): App {
            return app
        }

        val sp: SharedPreferences
            get() = get().sp
        val mHandle: Handler
            get() = get().mHandle
        val mThread: Handler
            get() = get().mThread
        val uiScope: CoroutineScope
            get() = get().uiScope
    }

    val mHandle: Handler by lazy { Handler(Looper.getMainLooper()) }
    val mThread: Handler by lazy { Handler(HandlerThread("thread").also { it.start() }.looper) }

    val sp: SharedPreferences by lazy { getSharedPreferences("default", 0) }

    val uiScope = MainScope()
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        app = this
    }

    override fun onCreate() {
        super.onCreate()
        BYDAutoUtils.init(this)
        val handle = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            log(t.name, e)
            val crashFile = File(cacheDir, "crash.log")
            if (!crashFile.exists()) {
                crashFile.createNewFile()
            }
            crashFile.printWriter().use { e.printStackTrace(it) }
            handle?.uncaughtException(t, e)
        }
        UiManager.isResume(this.packageName)
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingPermission: ")
    }
}