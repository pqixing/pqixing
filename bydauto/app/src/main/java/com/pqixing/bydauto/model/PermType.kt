package com.pqixing.bydauto.model

import android.Manifest
import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.cgutman.androidremotedebugger.AdbUtils
import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.launch

sealed class PermType {


    companion object {
        private val permissions = hashMapOf<PermType, Boolean>()

        fun enableAll(vararg types: PermType = arrayOf(Float, WriteSecure, ReadLogs)): Boolean {
            return types.all { it.enable() }
        }

        fun clearCache() {
            permissions.clear()
        }
    }

    fun enable(): Boolean {
        return permissions.getOrPut(this) { checkPerm(App.get()) }
    }

    fun toSet(context: Context, call: (s: Boolean) -> Unit = {}) {
        tryToSet(context) { result ->
            permissions[this] = result
            call(result)
        }
    }

    protected abstract fun checkPerm(context: Context): Boolean
   protected abstract fun tryToSet(context: Context, call: (s: Boolean) -> Unit = {})

    object Float : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return Settings.canDrawOverlays(context)
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.parse("package:${context.packageName}"))
            UiUtils.startResult(context, i) { call(checkPerm(context)) }
        }
    }

    object WriteSecure : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return UiUtils.checkSelfPermission(context, Manifest.permission.WRITE_SECURE_SETTINGS)
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            if (Adb.enable()) App.uiScope.launch {
                AdbManager.getClient()
                    .runSync("pm grant ${context.packageName} ${Manifest.permission.WRITE_SECURE_SETTINGS} \n")
                call(checkPerm(context))
            } else {
                val i = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                UiUtils.startResult(context, i) { call(checkPerm(context)) }
            }
        }
    }

    object ReadLogs : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return UiUtils.checkSelfPermission(context, Manifest.permission.READ_LOGS)
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            if (Adb.enable()) App.uiScope.launch {
                AdbManager.getClient().runSync("pm grant ${context.packageName} ${Manifest.permission.READ_LOGS}")
                call(checkPerm(context))
            } else {
                val cmd = "pm grant ${context.packageName} ${Manifest.permission.READ_LOGS}"
                AlertDialog.Builder(context).setTitle("申请权限").setMessage("请先通过adb命令授权日志权限: \n $cmd")
                    .setPositiveButton("确定") { d, i ->
                        context.getSystemService(ClipboardManager::class.java)
                            .setPrimaryClip(ClipData.newPlainText("Label", cmd))
                        App.toast("命令已复制到粘贴板")
                    }.show()
                call(checkPerm(context))
            }
        }
    }

    object Adb : PermType() {
        override fun checkPerm(context: Context): Boolean {
            return Const.SP_PERM_ADB_CONNECT
        }

        override fun tryToSet(context: Context, call: (s: Boolean) -> Unit) {
            AdbUtils.updateCryptoIfNeed(context.filesDir) {
                App.uiScope.launch {
                    val result =
                        AdbManager.getClient().runSync("getprop ro.build.id")
                    if (result.isSuccess) {
                        App.toast(result.getOrDefault(""))
                    } else {
                        App.toast("connect fail")
                    }
                    Const.SP_PERM_ADB_CONNECT = result.isSuccess
                    call(checkPerm(context))
                }
            }
        }
    }
}