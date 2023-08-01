package com.pqixing.bydauto.ui

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.utils.UiUtils

class BottomFloatView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

//    var bottomFloatHeight: Int = UiUtils.dp2dx(100)

    var barContent: TouchBarContentView
    var content: FrameLayout

    init {
        inflate(context, R.layout.ui_bottom_float, this)
        barContent = findViewById(R.id.ll_touch_bar)
        content = findViewById(R.id.fl_content)
        val items = listOf("最近", "主页", "全屏")
        barContent.setItems(items) { index, distance ->
            when (items[index]) {
                "最近" -> CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
                "主页" -> CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
                "全屏" -> UiUtils.switchFullScreen(context, !Const.SP_FULL_SCREEN)
            }

        }
    }
}