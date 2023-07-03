package com.pqixing.bydauto.setting.item

import android.content.Context
import android.widget.CheckBox
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl

class PermSet : SettingImpl(R.layout.setting_permission) {


    override fun getNameId(): Int = R.string.setting_name_permission

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        with(viewHolder.itemView) {
            val cbFloat = findViewById<CheckBox>(R.id.cb_float)
            val cbAccessibility = findViewById<CheckBox>(R.id.cb_accessibility)
            val cbReadLogs = findViewById<CheckBox>(R.id.cb_read_logs)

            cbFloat.isChecked = PermType.hasPermission(PermType.Float)
            cbAccessibility.isChecked = PermType.hasPermission(PermType.Accessibility)
            cbReadLogs.isChecked = PermType.hasPermission(PermType.ReadLogs)

            cbFloat.setOnClickListener { PermType.Float.tryToSetPerm(viewHolder.context) }
            cbAccessibility.setOnClickListener { PermType.Accessibility.tryToSetPerm(viewHolder.context) }
            cbReadLogs.setOnClickListener { PermType.ReadLogs.tryToSetPerm(viewHolder.context) }
        }
    }

    override fun isShow(context: Context): Boolean {
        return !PermType.hasAllPermission()
    }
}