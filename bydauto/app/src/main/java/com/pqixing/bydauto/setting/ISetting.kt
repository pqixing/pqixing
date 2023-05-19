package com.pqixing.bydauto.setting

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

interface ISetting {
    fun getName(): String
    fun onUiCreate(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View
    fun onServiceCreate(context: Context)
    fun onUiDestroy(activity: Activity)
    fun onServiceDestroy(context: Context)
}

abstract class DSetting(private var name: String) : ISetting {
    override fun getName(): String {
        return name
    }

    override fun onServiceCreate(context: Context) {
    }

    override fun onUiDestroy(activity: Activity) {
    }

    override fun onServiceDestroy(context: Context) {
    }

}
