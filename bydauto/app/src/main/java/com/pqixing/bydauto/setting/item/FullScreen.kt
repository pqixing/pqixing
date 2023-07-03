package com.pqixing.bydauto.setting.item

import android.widget.CheckBox
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.AdbClient
import com.pqixing.bydauto.utils.UiUtils

class FullScreen : SettingImpl(R.layout.setting_full_screen) {


    override fun getNameId(): Int = R.string.setting_name_full_screen

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val full = viewHolder.findViewById<CheckBox>(R.id.cb_full)

        full.isChecked = Const.SP_FULL_SCREEN
        full.setOnCheckedChangeListener { buttonView, isChecked ->
            val cmd = "wm overscan 0,${if (isChecked) -UiUtils.getStatusBarH(viewHolder.context) else 0},0,${
                if (isChecked) -UiUtils.getNavigationBarH(viewHolder.context) else 0
            }"
            AdbClient.getClient().runAsync(cmd)
        }
    }
}