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

sealed class PermType {
    companion object {
        private val permissions = hashMapOf<PermType, Boolean>()

        fun hasAllPermission(): Boolean {
            return hasPermission(Float) && hasPermission(Accessibility) && hasPermission(ReadLogs)
        }

        fun hasPermission(type: PermType): Boolean {
            return permissions[type] ?: type.checkPerm(App.get()).also { permissions[type] = it }
        }
        fun clearCache(){
            permissions.clear()
        }
    }

    protected abstract fun checkPerm(context: Context): Boolean
    abstract fun tryToSetPerm(context: Context)

    object Float : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return Settings.canDrawOverlays(context)
        }

        override fun tryToSetPerm(context: Context) {
            val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.parse("package:${context.packageName}"))
            context.startActivity(i)
        }
    }

    object Accessibility : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return CarAccessibilityService.connect
        }

        override fun tryToSetPerm(context: Context) {
            val i = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    object ReadLogs : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return UiUtils.checkSelfPermission(context, Manifest.permission.READ_LOGS)
        }

        override fun tryToSetPerm(context: Context) {
            AdbManager.getClient().runAsync("pm grant ${context.packageName} ${Manifest.permission.READ_LOGS}")
        }
    }
}