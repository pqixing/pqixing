package com.pqixing.bydauto.setting.item

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.UiUtils

class RotationItem : SettingImpl(R.layout.setting_rotate) {

    companion object {
        const val FLOAT_TAG_ROTATION = "FLOAT_TAG_ROTATION"
    }

    private val ids = listOf(
        R.id.rbFullSensor to ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR,
        R.id.rbLandScape to ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE,
        R.id.rbPortrait to ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT,
        R.id.rbUndefine to ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    )

    override fun onCreate(context: Context) {
        super.onCreate(context)
        updateFloatView(context, Const.SP_ORIENTATION)
    }

    private fun updateFloatView(context: Context, orientation: Int) {
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            UiUtils.closeFloatView(FLOAT_TAG_ROTATION)
        } else {
            UiUtils.showOrUpdateFloatView(FLOAT_TAG_ROTATION, layoutParams(orientation)) { View(context) }
        }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        UiUtils.closeFloatView(FLOAT_TAG_ROTATION)
    }

    override fun getNameId(): Int = R.string.setting_name_rotate

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val rotate: RadioGroup = viewHolder.findViewById(R.id.group)

        val lastCheckedId = ids.find { it.second == Const.SP_ORIENTATION }?.first ?: R.id.rbUndefine
        rotate.findViewById<RadioButton>(lastCheckedId)?.isChecked = true

        rotate.setOnCheckedChangeListener { v, checkedId ->
            val orientation = ids.find { it.first == checkedId }?.second ?: ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            Const.SP_ORIENTATION = orientation
            updateFloatView(v.context, orientation)
        }
    }

    private fun layoutParams(orientation: Int): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = 1
            it.height = 1
            it.format = PixelFormat.TRANSLUCENT
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            it.gravity = Gravity.START or Gravity.TOP

            it.screenOrientation = orientation
            it.alpha = 0f
        }
    }
}