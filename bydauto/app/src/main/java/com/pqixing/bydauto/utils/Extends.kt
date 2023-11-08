package com.pqixing.bydauto.utils

import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.pqixing.bydauto.App

val app: App
    get() = App.get()

//fun Context.hook(pkg: String? = null): Context = HookContext(this, pkg)
fun inMainThread(): Boolean {
    return Looper.myLooper() == Looper.getMainLooper()
}

val Int.dp: Int
    get() = UiUtils.dp2dx(this)

var String.spBoolean
    get() = App.sp.getBoolean(this, false)
    set(value) {
        App.sp.edit().putBoolean(this, value).apply()
    }
var String.spLong
    get() = App.sp.getLong(this, 0L)
    set(value) {
        App.sp.edit().putLong(this, value).apply()
    }
var String.spString
    get() = App.sp.getString(this, "")
    set(value) {
        App.sp.edit().putString(this, value).apply()
    }

fun CharSequence.toast(): CharSequence {
    log(tag = getStackName(4))
    val t = { Toast.makeText(App.get(), this, Toast.LENGTH_SHORT).show() }
    if (inMainThread()) {
        t.invoke()
    } else {
        App.get().mHandle.post(t)
    }
    return this
}

fun getStackName(index: Int): String {
    return Thread.currentThread().stackTrace.getOrNull(index)?.let { stactTrace ->
        "${stactTrace.className.substringAfterLast(".")}.${stactTrace.methodName}"
    } ?: "CAR"
}

fun <T : Any> T.log(level: Int = Log.DEBUG, tag: String = getStackName(4), thows: Throwable? = null): T {
    val msg = this.toString() ?: ""
    when (level) {
        Log.ERROR -> Log.e(tag, msg, thows)
        Log.WARN -> Log.w(tag, msg, thows)
        Log.INFO -> Log.i(tag, msg, thows)
        Log.VERBOSE -> Log.v(tag, msg, thows)
        else -> Log.d(tag, msg, thows)
    }
    return this
}
