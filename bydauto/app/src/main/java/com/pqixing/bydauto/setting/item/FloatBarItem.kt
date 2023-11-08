package com.pqixing.bydauto.setting.item

import android.content.Context
import android.view.View
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.HTouchView

class FloatBarItem : SettingImpl(R.layout.setting_float_bar) {

    val FLOAT_TAG_BAR_LEFT = "FLOAT_TAG_BAR_LEFT"
    val FLOAT_TAG_BAR_RIGHT = "FLOAT_TAG_BAR_RIGHT"

    override fun getNameId(): Int = R.string.setting_name_item_bar

    override fun onCreate(context: Context) {
        super.onCreate(context)
        UiUtils.showOrUpdate(FLOAT_TAG_BAR_LEFT) { HTouchView(context.applicationContext) }
        UiUtils.showOrUpdate(FLOAT_TAG_BAR_RIGHT) { HTouchView(context.applicationContext, View.LAYOUT_DIRECTION_RTL) }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        UiUtils.closeFloatView(FLOAT_TAG_BAR_LEFT)
        UiUtils.closeFloatView(FLOAT_TAG_BAR_RIGHT)
    }


    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
    }
}