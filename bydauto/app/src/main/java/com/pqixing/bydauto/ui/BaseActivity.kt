package com.pqixing.bydauto.ui

import android.app.Activity
import android.util.Log

open class BaseActivity : Activity() {
    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w(this.javaClass.simpleName, "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w(this.javaClass.simpleName, "enforceCallingPermission: ")
    }
}