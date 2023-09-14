package com.pqixing.bydauto.widget

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.utils.UiUtils

class MenuFloatView : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private var touch: TouchBarContentView
    private var content: ViewGroup

    private var left: Boolean = true

    init {
        inflate(context, R.layout.ui_recent_float, this)
        touch = findViewById(R.id.ll_touch_bar)
        content = findViewById(R.id.fl_content)
        val items = listOf(
            TouchBarContentView.BarItem("返回") { CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) },
            TouchBarContentView.BarItem("桌面") { CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME) },
            TouchBarContentView.BarItem("更多") { reShowContent() },
        )
        touch.setItems(items)
    }

    private var hideContent = object : Runnable {
        override fun run() {
            removeCallbacks(this)
            content.visibility = View.GONE
            touch.visibility = View.VISIBLE
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN && content.visibility == View.VISIBLE) {
            reShowContent()
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()
    }

    private fun createParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.WRAP_CONTENT
            it.height = resources.displayMetrics.heightPixels - UiUtils.dp2dx(160)
            it.format = PixelFormat.RGBA_8888
            it.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.gravity = if (left) Gravity.START or Gravity.CENTER_VERTICAL else Gravity.END or Gravity.CENTER_VERTICAL
            it.alpha = 1f
        }
    }

    private fun reShowContent() {
        removeCallbacks(hideContent)
        content.visibility = View.VISIBLE
        touch.visibility = View.GONE
        postDelayed(hideContent, Const.SP_DELAY_DISMISS)
    }

    fun setLeft(left: Boolean): MenuFloatView {
        if (this.left == left) return this
        this.left = left
        removeAllViews()
        if (left) {
            addView(touch)
            addView(content)
        } else {
            addView(content)
            addView(touch)
        }
        return this
    }

}