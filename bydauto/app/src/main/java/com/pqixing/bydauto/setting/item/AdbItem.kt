package com.pqixing.bydauto.setting.item

import android.Manifest
import android.accessibilityservice.AccessibilityService
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.cgutman.androidremotedebugger.AdbUtils
import com.cgutman.androidremotedebugger.ConnectActivity
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.CarAccessibilityService
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class AdbItem : SettingImpl(R.layout.setting_adb) {

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val view = viewHolder.itemView

        val group = view.findViewById<ViewGroup>(R.id.gd_group)
        for (i in 0 until group.childCount) {
            group.getChildAt(i).setOnClickListener { onChildCick(it) }
        }
        val full = viewHolder.findViewById<CheckBox>(R.id.cb_full)
        full.isChecked = Const.SP_FULL_SCREEN
        full.setOnCheckedChangeListener { buttonView, isChecked ->
            val cmd = "wm overscan 0,${if (isChecked) -UiUtils.getStatusBarH(viewHolder.context) else 0},0,${
                if (isChecked) -UiUtils.getNavigationBarH(viewHolder.context) else 0
            }"
            AdbManager.getClient().runAsync(cmd)
            Const.SP_FULL_SCREEN = isChecked
        }
    }

    override fun onCreate(context: Context) {
        super.onCreate(context)
        AdbUtils.updateCryptoIfNeed(context.filesDir) {}
    }

    override fun isShow(context: Context): Boolean {
        return PermType.Adb.enable()
    }

    private fun onChildCick(view: View) {
        App.uiScope.launch {
            val text = runCatching {
                when (view.id) {
                    R.id.tv_shell_ui -> view.context.startActivity(Intent(view.context, ConnectActivity::class.java))
                    R.id.tv_connection -> AdbManager.getClient().connection()
                    R.id.tv_read_log -> AdbManager.getClient().runSync("pm grant ${view.context.packageName} ${Manifest.permission.READ_LOGS} \n")
                    R.id.tv_pull_setting -> CarAccessibilityService.get()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
                    R.id.btn_stop -> exitProcess(0)
                    R.id.btn_accessibility -> {
                        val context = view.context
                        AdbManager.getClient().runSync("pm grant ${context.packageName} ${Manifest.permission.WRITE_SECURE_SETTINGS} \n")
                        Settings.Secure.putString(
                            context.contentResolver,
                            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES,
                            "${context.packageName}/${CarAccessibilityService::class.java.canonicalName}"
                        )
                        Settings.Secure.putInt(context.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED, 1)
                    }

                    else -> null
                }.toString()
            }.getOrElse { it.message }
            AlertDialog.Builder(view.context).setTitle("执行结果").setMessage(text).show()
        }
    }

    override fun getNameId(): Int {
        return R.string.setting_name_adb
    }

}