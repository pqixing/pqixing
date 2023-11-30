package com.pqixing.bydauto.setting.item

import android.content.Context
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.FloatMenuView

class FloatBarItem : SettingImpl(R.layout.setting_float_bar) {

    val FLOAT_TAG_BAR_MENU = "FLOAT_TAG_BAR_MENU"

    override fun getNameId(): Int = R.string.setting_name_item_bar

    override fun onCreate(context: Context) {
        super.onCreate(context)
        UiUtils.showOrUpdate(FLOAT_TAG_BAR_MENU) { FloatMenuView(context.applicationContext) }
//        UiUtils.showOrUpdate(FLOAT_TAG_BAR_RIGHT) { HTouchView(context.applicationContext, View.LAYOUT_DIRECTION_RTL) }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        UiUtils.closeFloatView(FLOAT_TAG_BAR_MENU)
    }


    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
    }
}