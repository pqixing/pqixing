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
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.ui.FloatBarView
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FloatBarItem : SettingImpl(R.layout.setting_float_bar) {

    val FLOAT_TAG_BAR_LEFT = "FLOAT_TAG_BAR_LEFT"
    val FLOAT_TAG_BAR_RIGHT = "FLOAT_TAG_BAR_RIGHT"
    val FLOAT_TAG_BAR_BOTTOM = "FLOAT_TAG_BAR_BOTTOM"

    override fun getNameId(): Int = R.string.setting_name_item_bar
    val floatTypes = arrayOf(FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT, FLOAT_TAG_BAR_BOTTOM)
    override fun onCreate(context: Context) {
        super.onCreate(context)
        if (Const.SP_FLOAT_BAR) {
            float(context)
        }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        floatTypes.forEach { UiUtils.closeFloatView(it) }
    }

    private fun float(context: Context) {
        val layoutManager = { type: String ->
            WindowManager.LayoutParams().also {
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
                    FLOAT_TAG_BAR_LEFT -> Gravity.START or Gravity.CENTER_VERTICAL
                    FLOAT_TAG_BAR_BOTTOM -> Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                    else -> Gravity.CENTER_VERTICAL
                }
                it.alpha = 1f
            }
        }

        val LONG_PRESS_TIME = 600L

        val onTouch = { type: String, gap: Long, e: MotionEvent, view: View ->
            App.uiScope.launch {

                when (type) {
                    FLOAT_TAG_BAR_BOTTOM -> CAService.perform(if (gap < LONG_PRESS_TIME) AccessibilityService.GLOBAL_ACTION_HOME else AccessibilityService.GLOBAL_ACTION_RECENTS)
                    FLOAT_TAG_BAR_LEFT, FLOAT_TAG_BAR_RIGHT -> {
                        if (e.y <= view.height / 2) {
                            App.toast("拖动了上边${e.y} $gap")
                            if (gap <= LONG_PRESS_TIME) CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) else {
                                CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
                                delay(LONG_PRESS_TIME)
                                UiUtils.tryLaunch(App.get(), "com.byd.automap")
                                delay(LONG_PRESS_TIME)
                                CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
                                UiUtils.tryLaunch(App.get(),
                                    BYDAutoUtils.getCurrentAudioFocusPackage()
                                        ?: Const.SP_MUSIC_PKG.takeIf { it.isNotEmpty() } ?: "com.kuwo.tingshu")

                            }
                        } else {
                            App.toast("拖动了下边 ${e.y} $gap")
                            if (gap <= LONG_PRESS_TIME) CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) else {
                                switchFullScreen(context, !Const.SP_FULL_SCREEN)
                            }
                        }
                    }

                }
            }
        }
        floatTypes.forEach {
            UiUtils.showOrUpdateFloatView(it, layoutManager(it)) {
                FloatBarView(context).also { view -> view.setOnTouchUp { gap, e -> onTouch(it, gap, e, view) } }
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
            switchFullScreen(viewHolder.context, isChecked)
        }
    }

    fun switchFullScreen(context: Context, full: Boolean) {
        val cmd = "wm overscan 0,${if (full) -UiUtils.getStatusBarH(context) else 0},0,${
            if (full) -UiUtils.getNavigationBarH(context) else 0
        }"
        AdbManager.getClient().runAsync(cmd)
        Const.SP_FULL_SCREEN = full
    }
}