package com.pqixing.bydauto.setting.item

import android.content.Context
import android.view.View
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl

class HideItem : SettingImpl(R.layout.setting_hide) {

    override fun getNameId(): Int = R.string.setting_name_sp
    override fun onCreate(context: Context) {
        super.onCreate(context)
        //检查权限获取情况

    }

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        viewHolder.itemView.findViewById<View>(R.id.fl_content).background = null
    }

    override fun showTitle(context: Context): Boolean {
        return false
    }

    override fun isShow(context: Context): Boolean {
        return true
    }
}