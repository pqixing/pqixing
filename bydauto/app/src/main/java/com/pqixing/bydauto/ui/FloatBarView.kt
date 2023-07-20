package com.pqixing.bydauto.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

class FloatBarView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var onDownTime = 0L
    private var onTouchUp: (gap: Long, e: MotionEvent) -> Unit = { _, _ -> }

    fun setOnTouchUp(onTouchUp: (gap: Long, e: MotionEvent) -> Unit) {
        this.onTouchUp = onTouchUp
    }

    init {
        minimumWidth = 10
        minimumHeight = 10
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        e ?: return false
        if (e.action == MotionEvent.ACTION_UP) {
            onTouchUp.invoke(System.currentTimeMillis() - onDownTime, e)
            background = ColorDrawable(Color.TRANSPARENT)
        }
        if (e.action == MotionEvent.ACTION_DOWN) {
            onDownTime = System.currentTimeMillis()
            background = ColorDrawable(Color.BLUE)
        }
        return true
    }
}