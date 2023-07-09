package com.pqixing.bydauto.setting.item

import android.content.Context
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.widget.CheckBox
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.ui.FloatBarView
import com.pqixing.bydauto.utils.UiUtils

class FloatBarItem : SettingImpl(R.layout.setting_float_bar) {

    val FLOAT_TAG_BAR_LEFT = "FLOAT_TAG_BAR_LEFT"
    val FLOAT_TAG_BAR_RIGHT = "FLOAT_TAG_BAR_RIGHT"

    override fun getNameId(): Int = R.string.setting_name_item_bar

    override fun onCreate(context: Context) {
        super.onCreate(context)
        if (Const.SP_FLOAT_BAR) {
            float(context)
        }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        UiUtils.closeFloatView(FLOAT_TAG_BAR_LEFT)
        UiUtils.closeFloatView(FLOAT_TAG_BAR_RIGHT)
    }

    private fun float(context: Context) {
        val layoutManager = { start: Boolean ->
            WindowManager.LayoutParams().also {
                it.width = WindowManager.LayoutParams.WRAP_CONTENT
                it.height = WindowManager.LayoutParams.WRAP_CONTENT
                it.format = PixelFormat.RGBA_8888
                it.flags =
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                it.gravity = (if (start) Gravity.START else Gravity.END) or Gravity.CENTER_VERTICAL
                it.alpha = 1f
            }
        }

        UiUtils.showOrUpdateFloatView(FLOAT_TAG_BAR_LEFT, layoutManager(false)) {
            FloatBarView(context).setReverse(false)
        }
        UiUtils.showOrUpdateFloatView(FLOAT_TAG_BAR_RIGHT, layoutManager(true)) {
            FloatBarView(context).setReverse(true)
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
    }
}