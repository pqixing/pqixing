package com.pqixing.bydauto.setting.item

import android.content.Context
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl

class HideItem : SettingImpl(R.layout.setting_gride) {

    override fun getNameId(): Int = R.string.setting_name_permission
    override fun onCreate(context: Context) {
        super.onCreate(context)
        //检查权限获取情况

    }

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val view = viewHolder.itemView
    }

    override fun isShow(context: Context): Boolean {
        return true
    }
}