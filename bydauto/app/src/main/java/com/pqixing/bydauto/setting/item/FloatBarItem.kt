package com.pqixing.bydauto.setting.item

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.CheckBox
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.ActionCASExe
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.service.LaunchCASExe
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.ui.FloatBarMenuView
import com.pqixing.bydauto.ui.FloatBarView
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.launch

class FloatBarItem : SettingImpl(R.layout.setting_float_bar) {

    val FLOAT_TAG_BAR_LEFT = "FLOAT_TAG_BAR_LEFT"
    val FLOAT_TAG_BAR_RIGHT = "FLOAT_TAG_BAR_RIGHT"
    val FLOAT_TAG_BAR_BOTTOM = "FLOAT_TAG_BAR_BOTTOM"
    val FLOAT_TAG_BAR_MEMU = "FLOAT_TAG_BAR_MEMU"

    override fun getNameId(): Int = R.string.setting_name_item_bar
    val floatTypes = mapOf(
        FLOAT_TAG_BAR_LEFT to R.drawable.float_bar_bg_left,
        FLOAT_TAG_BAR_RIGHT to R.drawable.float_bar_bg_right,
    )

    override fun onCreate(context: Context) {
        super.onCreate(context)
        if (Const.SP_FLOAT_BAR) {
            float(context)
        }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        floatTypes.forEach { UiUtils.closeFloatView(it.key) }
    }

    fun layoutManager(type: String): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width =
                if (type == FLOAT_TAG_BAR_BOTTOM) WindowManager.LayoutParams.MATCH_PARENT else WindowManager.LayoutParams.WRAP_CONTENT
            it.height =
                if (type == FLOAT_TAG_BAR_BOTTOM) WindowManager.LayoutParams.WRAP_CONTENT else WindowManager.LayoutParams.MATCH_PARENT
            it.format = PixelFormat.RGBA_8888
            it.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.gravity = when (type) {
                FLOAT_TAG_BAR_RIGHT -> Gravity.END or Gravity.CENTER_VERTICAL
                FLOAT_TAG_BAR_LEFT -> Gravity.START or Gravity.CENTER
                FLOAT_TAG_BAR_BOTTOM -> Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                else -> Gravity.CENTER_VERTICAL
            }
            it.alpha = 1f
        }
    }

    private fun float(context: Context) {

        val onTouch = { type: String, short: Boolean, e: MotionEvent, view: View ->
            App.uiScope.launch {
                val t = view.height / 3
                when (type) {
                    FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT -> {
                        when {
                            short && e.y <= t -> CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK)
                            !short && e.y <= t -> UiUtils.switchFullScreen(context, !Const.SP_FULL_SCREEN)
                            !short && e.y <= t * 2 -> {
                                CAService.performs(
                                    ActionCASExe(AccessibilityService.GLOBAL_ACTION_HOME) to 0L,
                                    LaunchCASExe("com.byd.automap") to 100L,
                                    ActionCASExe(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) to 500L,
                                    LaunchCASExe(getDefualtMusic()) to 500L,
                                )
                            }

                            short && e.y <= t * 2 -> UiUtils.showOrUpdateFloatView(
                                FLOAT_TAG_BAR_MEMU,
                                layoutManager(type).also {
                                    it.x = UiUtils.dp2dx(30)
                                    it.height = WindowManager.LayoutParams.WRAP_CONTENT
                                }) {
                                FloatBarMenuView(view.context)
                            }

                            short && e.y <= t * 3 -> CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
                            !short && e.y <= t * 3 -> CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
                        }
                    }

                }
            }
        }
        floatTypes.forEach {
            UiUtils.showOrUpdateFloatView(it.key, layoutManager(it.key)) {
                FloatBarView(context).also { view ->
                    view.setOnTouchUp(context.getDrawable(it.value)) { short, e -> onTouch(it.key, short, e, view) }
                }
            }
        }
    }

    fun getDefualtMusic(): String {
        return BYDAutoUtils.getCurrentAudioFocusPackage()?.trim()?.takeIf { it.isNotEmpty() }
            ?: Const.SP_MUSIC_PKG.trim().takeIf { it.isNotEmpty() }
            ?: "com.kuwo.tingshu"
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