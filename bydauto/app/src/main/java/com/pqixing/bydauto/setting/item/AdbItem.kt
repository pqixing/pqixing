package com.pqixing.bydauto.setting.item

import android.accessibilityservice.AccessibilityService
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
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
                    R.id.tv_pull_setting -> CarAccessibilityService.get()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_QUICK_SETTINGS)
                    R.id.tv_pull_notify -> CarAccessibilityService.get()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
                    R.id.tv_action_split -> CarAccessibilityService.get()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
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