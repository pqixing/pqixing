package com.pqixing.bydauto.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.utils.dp
import kotlin.math.roundToInt

class SeekbarView : LinearLayout {


    private var clipBg: Drawable
    private var value: String = ""
    private var listener: ISeekBarView? = null
    private var values: Array<String> = emptyArray()
    private val delayMls = 10000L

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        var bg = (background as? LayerDrawable)?.findDrawableByLayerId(android.R.id.progress)
        if (bg == null) {
            val nbg = context.getDrawable(R.drawable.seekbar_progress_drawable)
            bg = (background as LayerDrawable).findDrawableByLayerId(android.R.id.progress)
            background = nbg
        }
        clipBg = bg!!
        addChildTextView(context, Gravity.START)
        addChildTextView(context, Gravity.CENTER)
        addChildTextView(context, Gravity.END)
        setData("20", IntRange(0, 100).map { it.toString() }, null)
    }

    private var autoClose: Runnable? = null

    fun setAutoClose(close: Runnable) {
        this.autoClose = close
        postDelayed(autoClose, delayMls)
    }

    fun setValue(value: String) {
        setValue(values.indexOf(value), false)
    }

    private fun setValue(index: Int, fromUser: Boolean) {
        this.value = values.getOrNull(index) ?: return
        clipBg.level = ((index + 1) * 10000f / values.size).roundToInt()
        listener?.onProgressChanged(this, value, fromUser)
        (getChildAt(1) as TextView).text = value
    }

    fun setData(default: String, values: Collection<String>, listener: ISeekBarView?) {
        this.listener = null
        this.values = values.toTypedArray()
        (getChildAt(0) as TextView).text = values.first().toString()
        (getChildAt(2) as TextView).text = values.last().toString()
        setValue(default)
        this.listener = listener
        removeCallbacks(autoClose)
        postDelayed(autoClose, delayMls)
    }

    private fun addChildTextView(context: Context, gravity: Int) {
        val center = gravity == Gravity.CENTER
        val tv = TextView(context)
        tv.gravity = gravity or Gravity.CENTER_VERTICAL
        tv.textSize = if (center) 26f else 16f
        tv.setTextColor(context.getColor(if (center) android.R.color.holo_orange_light else android.R.color.black))
        val padding = 10.dp
        tv.setPadding(padding, 0, padding, 0)
        val params = LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
        addView(tv, params)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return false
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                removeCallbacks(autoClose)
                requestDisallowInterceptTouchEvent(true)
                listener?.onStartTrackingTouch(this)
                updateProgress(event)
            }

            MotionEvent.ACTION_MOVE -> {
                updateProgress(event)
            }

            MotionEvent.ACTION_UP -> {
                updateProgress(event)
                listener?.onStopTrackingTouch(this, value)
                postDelayed(autoClose, delayMls / 3)
            }
        }
        return true
    }

    private fun updateProgress(event: MotionEvent) {
        val index = ((event.x / width).coerceAtMost(0.999f).coerceAtLeast(0f) * values.size).toInt()
        setValue(index, true)
    }
}

interface ISeekBarView {
    fun onProgressChanged(seekBar: SeekbarView, value: String, fromUser: Boolean)

    /**
     * Notification that the user has started a touch gesture. Clients may want to use this
     * to disable advancing the seekbar.
     * @param seekBar The SeekBar in which the touch gesture began
     */
    fun onStartTrackingTouch(seekBar: SeekbarView)

    /**
     * Notification that the user has finished a touch gesture. Clients may want to use this
     * to re-enable advancing the seekbar.
     * @param seekBar The SeekBar in which the touch gesture began
     */
    fun onStopTrackingTouch(seekBar: SeekbarView, value: String)
}

class SimpleImpl(val onStopTrack: (seekBar: SeekbarView, value: String) -> Unit) : ISeekBarView {
    override fun onProgressChanged(seekBar: SeekbarView, value: String, fromUser: Boolean) {

    }

    override fun onStartTrackingTouch(seekBar: SeekbarView) {
    }

    override fun onStopTrackingTouch(seekBar: SeekbarView, value: String) {
        onStopTrack.invoke(seekBar, value)
    }

}

