package com.pqixing.bydauto.setting.item

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import com.cgutman.androidremotedebugger.AdbUtils
import com.cgutman.androidremotedebugger.ConnectActivity
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import kotlinx.coroutines.launch

class AdbItem : SettingImpl(R.layout.setting_adb) {

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val view = viewHolder.itemView

        val group = view.findViewById<ViewGroup>(R.id.gd_group)
        for (i in 0 until group.childCount) {
            group.getChildAt(i).setOnClickListener { onChildCick(it) }
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
                    R.id.tv_pull_setting -> CAService.perform(AccessibilityService.GLOBAL_ACTION_QUICK_SETTINGS)
                    R.id.tv_pull_notify -> CAService.perform(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
                    R.id.tv_action_split -> CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
                    else -> null
                }.toString()
            }.getOrElse { it.message }
            App.toast("result : $text")
//            AlertDialog.Builder(view.context).setTitle("执行结果").setMessage(text).show()
        }
    }

    override fun getNameId(): Int {
        return R.string.setting_name_adb
    }

}