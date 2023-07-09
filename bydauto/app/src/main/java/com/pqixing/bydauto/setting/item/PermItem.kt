package com.pqixing.bydauto.setting.item

import android.content.Context
import android.widget.CheckBox
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl

class PermItem : SettingImpl(R.layout.setting_permission) {

    override fun getNameId(): Int = R.string.setting_name_permission

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val view = viewHolder.itemView

        val permMap = mapOf(
            PermType.Float to view.findViewById(R.id.cb_float),
            PermType.ReadLogs to view.findViewById(R.id.cb_read_logs),
            PermType.Accessibility to view.findViewById(R.id.cb_accessibility),
            PermType.Adb to view.findViewById<CheckBox>(R.id.cb_adb),
        )
        permMap.forEach { item ->
            item.value.isChecked = item.key.enable()
            item.value.setOnClickListener {
                item.key.tryToSet(view.context) { check -> item.value.isChecked = check }
                item.value.isChecked = item.key.enable()
            }
        }
    }

    override fun isShow(context: Context): Boolean {
        return true
    }
}