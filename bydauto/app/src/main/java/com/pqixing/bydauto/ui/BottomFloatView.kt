package com.pqixing.bydauto.ui

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.CAService

class BottomFloatView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

//    var bottomFloatHeight: Int = UiUtils.dp2dx(100)

    var barContent: TouchBarContentView
    var content: LinearLayout

    init {
        inflate(context, R.layout.ui_bottom_float, this)
        barContent = findViewById(R.id.ll_touch_bar)
        content = findViewById(R.id.fl_content)

        val items = listOf(
            TouchBarContentView.BarItem("导航栏") {
                content.visibility =
                    if (content.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            },
            TouchBarContentView.BarItem("主页", 3) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
            },
            TouchBarContentView.BarItem("最近") {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
            },
        )
        barContent.setItems(items)
    }
}