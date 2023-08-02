package com.pqixing.bydauto.ui

import android.content.Context
import android.graphics.Color
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
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    var onTouchItems = listOf<BarItem>()
    var vertica = false

    var onDown = -1
    var allWeight = 0
    val unValidDistance = UiUtils.dp2dx(250)

    fun setItems(items: List<BarItem>) {
        this.vertica = orientation == VERTICAL
        val horizontalMargin = if (vertica) UiUtils.dp2dx(2) else UiUtils.dp2dx(5)
        val verticalMargin = if (vertica) UiUtils.dp2dx(5) else UiUtils.dp2dx(2)

        onTouchItems = items
        allWeight = items.sumOf { it.weight }

        removeAllViews()
        items.forEach {
            val params = LayoutParams(
                if (vertica) LayoutParams.MATCH_PARENT else 0,
                if (vertica) 0 else LayoutParams.MATCH_PARENT,
                it.weight.toFloat()
            )
            params.bottomMargin = verticalMargin
            params.topMargin = verticalMargin

            params.leftMargin = horizontalMargin
            params.rightMargin = horizontalMargin

            val child = View(context)
            Color.YELLOW
            child.setBackgroundResource(R.drawable.bg_item_press)
            addView(child, params)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return true

        val d = (if (vertica) event.x else event.y).toInt()
        if (onDown == -1) onDown = d
        var w =
            ((if (vertica) event.y / height else event.x / width) * allWeight)

        val index = onTouchItems.indexOfFirst {
            w -= it.weight
            w <= 0f
        }

        val distance = (d - onDown).absoluteValue
        if (event.action == MotionEvent.ACTION_UP && distance <= unValidDistance) {
            onTouchItems.getOrNull(index)?.click?.onClick(getChildAt(index))
        }

        val press = event.action == MotionEvent.ACTION_MOVE || event.action == MotionEvent.ACTION_DOWN
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.isPressed = press && index == i && distance <= unValidDistance
            child.isSelected = press
        }
        return true
    }

    data class BarItem(val name: String, val weight: Int = 1, val click: View.OnClickListener)
}