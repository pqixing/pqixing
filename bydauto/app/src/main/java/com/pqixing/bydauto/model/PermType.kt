package com.pqixing.bydauto.model

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.pqixing.bydauto.App
import com.pqixing.bydauto.service.CarAccessibilityService
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.launch

sealed class PermType {

    companion object {
        private val permissions = hashMapOf<PermType, Boolean>()

        fun enableAll(vararg types: PermType = arrayOf(Float, Accessibility, ReadLogs)): Boolean {
            return types.all { it.enable() }
        }

        fun enable(type: PermType): Boolean {
            return permissions[type] ?: type.checkPerm(App.get()).also { permissions[type] = it }
        }

        fun clearCache() {
            permissions.clear()
        }
    }

    fun enable(): Boolean {
        return Companion.enable(this)
    }

    protected abstract fun checkPerm(context: Context): Boolean
    abstract fun tryToSet(context: Context, call: (s: Boolean) -> Unit = {})

    object Float : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return Settings.canDrawOverlays(context)
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.parse("package:${context.packageName}"))
            context.startActivity(i)
        }
    }

    object Accessibility : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return UiUtils.isAccessibilitySettingsOn(context, CarAccessibilityService::class.java)
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            val i = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    object ReadLogs : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return UiUtils.checkSelfPermission(context, Manifest.permission.READ_LOGS)
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            App.uiScope.launch {
                val result =
                    AdbManager.getClient().runSync("pm grant ${context.packageName} ${Manifest.permission.READ_LOGS}")
                call(result.isSuccess)
            }
        }
    }

    object Adb : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return Const.SP_PERM_ADB_CONNECT
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            App.uiScope.launch {
                val result =
                    AdbManager.getClient().runSync("getprop ro.build.id")
                if (result.isSuccess) {
                    App.toast(result.getOrDefault(""))
                }
                Const.SP_PERM_ADB_CONNECT = result.isSuccess
                call(result.isSuccess)
            }
        }
    }
}