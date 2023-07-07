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
        with(viewHolder.itemView) {
            val cbFloat = findViewById<CheckBox>(R.id.cb_float)
            val cbAccessibility = findViewById<CheckBox>(R.id.cb_accessibility)
            val cbReadLogs = findViewById<CheckBox>(R.id.cb_read_logs)
            val cbAdb = findViewById<CheckBox>(R.id.cb_adb)

            cbFloat.isChecked = PermType.Float.enable()
            cbAccessibility.isChecked = PermType.Accessibility.enable()
            cbReadLogs.isChecked = PermType.ReadLogs.enable()
            cbAdb.isChecked = PermType.Adb.enable()

            cbFloat.setOnClickListener { PermType.Float.tryToSet(viewHolder.context) }
            cbAccessibility.setOnClickListener { PermType.Accessibility.tryToSet(viewHolder.context) }
            cbAdb.setOnClickListener { PermType.Adb.tryToSet(viewHolder.context) }
        }
    }

    override fun isShow(context: Context): Boolean {
        return true
    }
}