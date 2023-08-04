package com.pqixing.bydauto.ui

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.CAService

class RecentFloatView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private var touch: TouchBarContentView
    private var content: FrameLayout


    init {
        inflate(context, R.layout.ui_recent_float, this)
        touch = findViewById(R.id.ll_touch_bar)
        content = findViewById(R.id.fl_content)
        val items = listOf(

            TouchBarContentView.BarItem("返回") { CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) },
            TouchBarContentView.BarItem("多任务") { CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS) },
        )
        touch.setItems(items)
    }


    fun setLeft(left: Boolean): RecentFloatView {
        val params = touch.layoutParams as LayoutParams
        params.gravity = if (left) Gravity.LEFT else Gravity.RIGHT
        return this
    }

}