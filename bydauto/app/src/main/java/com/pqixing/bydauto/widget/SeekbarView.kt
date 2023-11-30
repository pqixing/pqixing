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
    private var value: Int = -1
    private var listener: ISeekBarView? = null
    private var values: IntArray = IntArray(0)

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
        setData(20, IntRange(0, 100).toList().toIntArray(), null)
    }

    private var autoClose: Runnable? = null

    fun setAutoClose(close: Runnable) {
        this.autoClose = close
        postDelayed(autoClose, 20000)
    }

    fun setProgress(value: Int) {
        setProgress(values.indexOf(value), false)
    }

    private fun setProgress(index: Int, fromUser: Boolean) {
        this.value = values.getOrNull(index) ?: -1
        clipBg.level = ((index + 1) * 10000f / values.size).roundToInt()
        listener?.onProgressChanged(this, value, fromUser)
        (getChildAt(1) as TextView).text = value.toString()
    }

    fun setData(default: Int, values: IntArray, listener: ISeekBarView?) {
        this.listener = null
        this.values = values
        (getChildAt(0) as TextView).text = values.first().toString()
        (getChildAt(2) as TextView).text = values.last().toString()
        setProgress(default)
        this.listener = listener
        removeCallbacks(autoClose)
        postDelayed(autoClose, 20000)
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
                postDelayed(autoClose, 10000)
            }
        }
        return true
    }

    private fun updateProgress(event: MotionEvent) {
        val index = ((event.x / width).coerceAtMost(0.999f).coerceAtLeast(0f) * values.size).toInt()
        setProgress(index, true)
    }
}

interface ISeekBarView {
    fun onProgressChanged(seekBar: SeekbarView, progress: Int, fromUser: Boolean)

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
    fun onStopTrackingTouch(seekBar: SeekbarView, progress: Int)
}
class SimpleImpl(val onStopTrack: (seekBar: SeekbarView, progress: Int) -> Unit) :ISeekBarView{
    override fun onProgressChanged(seekBar: SeekbarView, progress: Int, fromUser: Boolean) {

    }

    override fun onStartTrackingTouch(seekBar: SeekbarView) {
    }

    override fun onStopTrackingTouch(seekBar: SeekbarView, progress: Int) {
        onStopTrack.invoke(seekBar,progress)
    }

}

