package com.pqixing.bydauto.setting.item

import android.content.Context
import android.widget.CheckBox
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.MenuFloatView
import com.pqixing.bydauto.widget.StatusBarView

class FloatBarItem : SettingImpl(R.layout.setting_float_bar) {

    val FLOAT_TAG_BAR_LEFT = "FLOAT_TAG_BAR_LEFT"
    val FLOAT_TAG_BAR_RIGHT = "FLOAT_TAG_BAR_RIGHT"
    val FLOAT_TAG_BAR_BOTTOM = "FLOAT_TAG_BAR_BOTTOM"

    val FLOAT_TAG_BAR_MEMU = "FLOAT_TAG_BAR_MEMU"

    override fun getNameId(): Int = R.string.setting_name_item_bar
    val floatTypes = arrayOf(FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT, FLOAT_TAG_BAR_BOTTOM)

    override fun onCreate(context: Context) {
        super.onCreate(context)
        float(context)
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        floatTypes.forEach { UiUtils.closeFloatView(it) }
    }

    private fun float(context: Context) {
        floatTypes.forEach {
            UiUtils.showOrUpdate(it) {
                if (it == FLOAT_TAG_BAR_BOTTOM) {
                    StatusBarView(context)
                } else {
                    MenuFloatView(context).setLeft(it == FLOAT_TAG_BAR_LEFT)
                }
            }
        }
    }

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val bar = viewHolder.findViewById<CheckBox>(R.id.cb_float_bar)

        bar.isChecked = Const.SP_FLOAT_BAR
        bar.setOnCheckedChangeListener { buttonView, isChecked ->
            Const.SP_FLOAT_BAR = isChecked
            if (isChecked) float(buttonView.context) else {
                UiUtils.closeFloatView(FLOAT_TAG_BAR_LEFT)
                UiUtils.closeFloatView(FLOAT_TAG_BAR_RIGHT)
            }
        }

        val full = viewHolder.findViewById<CheckBox>(R.id.cb_full)
        full.isChecked = Const.SP_FULL_SCREEN
        full.setOnCheckedChangeListener { buttonView, isChecked ->
            UiUtils.switchFullScreen(viewHolder.context, isChecked)
        }
    }
}