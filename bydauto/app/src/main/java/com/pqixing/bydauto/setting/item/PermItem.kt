package com.pqixing.bydauto.setting.item

import android.Manifest
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.cgutman.androidremotedebugger.AdbUtils
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.NTService
import com.pqixing.bydauto.setting.GridSetting
import com.pqixing.bydauto.ui.MainUI
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.ui.SingleItemAdapter
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.SettingManager
import com.pqixing.bydauto.utils.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class PermItem : GridSetting(R.string.setting_name_permission) {


    override fun getGridDatas(context: Context, adapter: SingleItemAdapter): List<SingleItem> {
        return listOf(
            SingleItem("一键授权") { grantAll(context, adapter) },
            SingleItem.empty, SingleItem.empty, SingleItem("停止应用") { exitProcess(0) },
            SingleItem(context.getString(R.string.permission_float), select = SettingManager.perms.float) {
                context.startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION).setData(Uri.parse("package:${context.packageName}")))
            },
            SingleItem(context.getString(R.string.permission_read_logs), select = SettingManager.perms.log) {
                val cmd = "pm grant ${context.packageName} ${Manifest.permission.READ_LOGS}"
                context.getSystemService(ClipboardManager::class.java)
                    .setPrimaryClip(ClipData.newPlainText("Label", cmd))
                "命令已复制:$cmd".toast()
            },
            SingleItem(context.getString(R.string.permission_write_secure), select = SettingManager.perms.secure) {
                context.startActivity(Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS))
            },
            SingleItem(context.getString(R.string.permission_notify), select = SettingManager.perms.notify) {
                context.startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            },
        )
    }


    override fun onCreate(context: Context) {
        super.onCreate(context)
        AdbUtils.updateCryptoIfNeed(context.filesDir) {}
    }

    private fun grantAll(context: Context, adapter: SingleItemAdapter) {
        App.uiScope.launch {
            val adb = AdbManager.getClient()
            if (adb.connection() == null) {
                "adb权限异常".toast()
                return@launch
            }
            adb.queueCommand(gs(Manifest.permission.READ_LOGS))
            adb.queueCommand("cmd notification allow_listener ${context.packageName}/${NTService::class.java.canonicalName}")
            adb.queueCommand(gs(Manifest.permission.WRITE_SECURE_SETTINGS))
            adb.queueCommand(gs(Manifest.permission.SYSTEM_ALERT_WINDOW))
            adb.queueCommand(gs(Manifest.permission.HIDE_OVERLAY_WINDOWS))

            "执行完成，即将重启".toast()
            delay(500)
            context.startActivity(Intent(context, MainUI::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            exitProcess(0)
        }
    }

    private fun gs(perm: String) = "pm grant ${App.get().packageName} $perm"

    override fun isShow(context: Context): Boolean {
        return !SettingManager.prepare || super.isShow(context)
    }
}