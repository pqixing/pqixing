package com.pqixing.bydauto.setting.item

import android.Manifest
import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.widget.TextView
import com.cgutman.androidremotedebugger.AdbUtils
import com.cgutman.androidremotedebugger.ConnectActivity
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.CarAccessibilityService
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.AdbManager
import kotlinx.coroutines.launch

class AdbSetting : SettingImpl(R.layout.setting_adb) {

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val view = viewHolder.itemView
        val result = view.findViewById<TextView>(R.id.tv_result)

        val group = view.findViewById<ViewGroup>(R.id.gd_group)
        for (i in 0 until group.childCount) {
            group.getChildAt(i).setOnClickListener { onChildCick(it.id, result) }
        }
    }

    override fun onCreate(context: Context) {
        super.onCreate(context)
        AdbUtils.updateCryptoIfNeed(context.filesDir)
    }

    override fun isShow(context: Context): Boolean {
        return PermType.Accessibility.enable()
    }

    private fun onChildCick(id: Int, result: TextView) {
        App.uiScope.launch {
            result.text = runCatching {
                when (id) {
                    R.id.tv_shell_ui -> result.context.startActivity(Intent(result.context, ConnectActivity::class.java))
                    R.id.tv_connection -> AdbManager.getClient().connection()
                    R.id.tv_connection_test -> AdbManager.getClient().runSync("ls")
                    R.id.tv_read_log -> AdbManager.getClient().runSync("pm grant ${result.context.packageName} ${Manifest.permission.READ_LOGS} \n")
                    R.id.tv_pull_setting -> CarAccessibilityService.get()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
                    R.id.tv_pull_notify ->CarAccessibilityService.get()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_QUICK_SETTINGS)
                    else -> null
                }.toString()
            }.getOrElse { it.message }
        }
    }

    override fun getNameId(): Int {
        return R.string.setting_name_debug
    }

}