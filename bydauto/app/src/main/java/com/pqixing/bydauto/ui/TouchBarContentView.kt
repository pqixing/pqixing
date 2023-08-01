package com.pqixing.bydauto.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.utils.UiUtils
import kotlin.math.absoluteValue

class TouchBarContentView : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    var onTouchItems = listOf<View>()
    var onTapUp: (index: Int, distance: Int) -> Unit = { _, _ -> }
    var vertica = false

    var onDown = -1

    fun setItems(items: List<String>, onTapUp: (index: Int, distance: Int) -> Unit) {
        this.onTapUp = onTapUp
        this.vertica = orientation == VERTICAL
        val horizontalMargin = if (vertica) UiUtils.dp2dx(2) else UiUtils.dp2dx(5)
        val verticalMargin = if (vertica) UiUtils.dp2dx(5) else UiUtils.dp2dx(2)
        onTouchItems = items.map {
            val params = LayoutParams(
                if (vertica) LayoutParams.MATCH_PARENT else 0,
                if (vertica) 0 else LayoutParams.MATCH_PARENT,
                1f
            )
            params.bottomMargin = verticalMargin
            params.topMargin = verticalMargin

            params.leftMargin = horizontalMargin
            params.rightMargin = horizontalMargin

            val child = View(context)
            child.setBackgroundResource(R.drawable.bg_item_press)
            addView(child, params)
            child
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return true

        val d = (if (vertica) event.x else event.y).toInt()
        if (onDown == -1) onDown = d
        val index = ((if (vertica) event.y / height else event.x / width) * onTouchItems.size).toInt()
        val distance = (d - onDown).absoluteValue

        if (event.action == MotionEvent.ACTION_UP) {
            onTouchItems.forEach { child ->
                child.isPressed = false
                child.isSelected = false
            }
            onTapUp(index, distance)
        } else {
            onTouchItems.forEachIndexed { i, pair ->
                pair.isSelected = true
                pair.isPressed = index == i
            }
        }
        return true
    }
}