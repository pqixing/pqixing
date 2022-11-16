package com.pqixing.android.radar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import android.widget.TextView

class MoveTextView : TextView {
    val space = 20

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        isFocusable = true
        setTextColor(Color.WHITE)
        textSize = 18f
        isClickable = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val params = layoutParams as? FrameLayout.LayoutParams ?: return false
        val x = (event.rawX - width).toInt() / space * space
        val y = (event.rawY - height).toInt() / space * space
        if (x != params.leftMargin || y != params.topMargin) {
            params.leftMargin = x
            params.topMargin = y
            layoutParams = params
        }
        return true
    }
}