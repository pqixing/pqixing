package com.pqixing.bydauto.widget

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.children
import com.pqixing.bydauto.R
import com.pqixing.bydauto.ui.SingleItem

class SingleView : FrameLayout {

    val icon: ImageView? by lazy { findViewById(R.id.iv_icon) }
    val name: TextView? by lazy { findViewById(R.id.tv_name) }
    val tip: TextView? by lazy { findViewById(R.id.tv_tip) }
    private var touchHelper: TouchHelper? = null
    private var iconId: Int = 0
    fun setTouchHelper(touchHelper: TouchHelper) {
        this.touchHelper = touchHelper
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return touchHelper?.onInterceptTouchEvent(ev) ?: super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return touchHelper?.onTouchEvent(event) ?: super.onTouchEvent(event)
    }

    override fun requestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept)
        touchHelper?.requestDisallowInterceptTouchEvent(disallowIntercept)
    }


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.SingleView, defStyleAttr, defStyleRes)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            saveAttributeDataForStyleable(context, R.styleable.SingleView, attrs, a, defStyleAttr, defStyleRes)
        }
        val layoutId = a.getResourceId(R.styleable.SingleView_layout, R.layout.single_item_default)
        //加载默认的布局
        View.inflate(context, layoutId, this)
        a.getDrawable(R.styleable.SingleView_icon)?.also { icon?.setImageDrawable(it) }

        val nameId = a.getResourceId(R.styleable.SingleView_name, 0)
        if (nameId != 0) {
            name?.text = context.getString(nameId)
        }
        a.getText(R.styleable.SingleView_name)?.also { name?.text = it }

        val tipId = a.getResourceId(R.styleable.SingleView_tip, 0)
        if (tipId != 0) {
            tip?.text = context.getString(tipId)
        }
        a.getText(R.styleable.SingleView_tip)?.also { tip?.text = it }

        iconId = a.getResourceId(R.styleable.SingleView_icon, 0)
        if (iconId != 0) {
            icon?.setImageResource(iconId)
        }

        a.recycle()

        updateChildSelect()
        isClickable = true
    }

    private fun updateChildSelect() {
        children.forEach { it.isSelected = isSelected }
    }
    fun getIconId():Int{
        return iconId
    }

    fun setItem(item: SingleItem) {
        if (item.icon != 0) {
            this.iconId = item.icon
            icon?.setImageResource(item.icon)
        }
        if (item.drawable != null) {
            icon?.setImageDrawable(item.drawable)
        }
        name?.text = item.name
        isSelected = item.select
        updateChildSelect()
        this.setOnClickListener(item.click)
    }

}


