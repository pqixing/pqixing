package com.pqixing.bydauto.setting.item

import android.content.Context
import android.widget.CheckBox
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.StatusBarView

class FloatBarItem : SettingImpl(R.layout.setting_float_bar) {

    val FLOAT_TAG_BAR_LEFT = "FLOAT_TAG_BAR_LEFT"
    val FLOAT_TAG_BAR_RIGHT = "FLOAT_TAG_BAR_RIGHT"
    val FLOAT_TAG_BAR_TOP = "FLOAT_TAG_BAR_TOP"

    override fun getNameId(): Int = R.string.setting_name_item_bar

    override fun onCreate(context: Context) {
        super.onCreate(context)
        if (Const.SP_FLOAT_BAR) {
            float(context, arrayOf(FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT))
        }
        if (Const.SP_FLOAT_STATUS) {
            float(context, arrayOf(FLOAT_TAG_BAR_TOP))
        }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        close(context, arrayOf(FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT, FLOAT_TAG_BAR_TOP))
    }

    private fun float(context: Context, types: Array<String>) {
        types.forEach {
            UiUtils.showOrUpdate(it) {
                StatusBarView(context.applicationContext)
            }
        }
    }

    private fun close(context: Context, types: Array<String>) {
        types.forEach { UiUtils.closeFloatView(it) }
    }

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        var bar = viewHolder.findViewById<CheckBox>(R.id.cb_float_bar)

        bar.isChecked = Const.SP_FLOAT_BAR
        bar.setOnCheckedChangeListener { buttonView, isChecked ->
            Const.SP_FLOAT_BAR = isChecked
            if (isChecked) float(buttonView.context, arrayOf(FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT)) else {
                close(buttonView.context, arrayOf(FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT))
            }
        }

        bar = viewHolder.findViewById<CheckBox>(R.id.cb_float_status_bar)
        bar.isChecked = Const.SP_FLOAT_STATUS
        bar.setOnCheckedChangeListener { buttonView, isChecked ->
            Const.SP_FLOAT_STATUS = isChecked
            if (isChecked) float(buttonView.context, arrayOf(FLOAT_TAG_BAR_TOP)) else {
                close(buttonView.context, arrayOf(FLOAT_TAG_BAR_TOP))
            }
        }
    }
}