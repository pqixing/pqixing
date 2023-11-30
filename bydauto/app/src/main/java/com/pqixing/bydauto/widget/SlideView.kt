package com.pqixing.bydauto.widget

import android.content.Context
import android.graphics.PointF
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.widget.FrameLayout
import kotlin.math.absoluteValue

abstract class SlideView : FrameLayout {


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
    }

    private var lastGravity = Gravity.NO_GRAVITY
    private var downEvent: PointF = PointF(0f, 0f)
    private var lastEvent: PointF = PointF(0f, 0f)

    //0 未处理，-1 不拦截， 1 拦截普通事件，2 拦截长按拖动事件
    private var intercept: Int = 0
    private val handle = Handler(Looper.getMainLooper())
    private val onMoveStart = Runnable { intercept = 2 }
    private var move = false


    abstract fun canMove(): Boolean
    abstract fun canSwipe(gravity: Int): Boolean
    abstract fun onMove(dx: Int, dy: Int, up: Boolean)
    abstract fun onSwipe(gravity: Int, up: Boolean)
    abstract fun onClick()

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        ev ?: return false
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                handle.removeCallbacks(onMoveStart)
                intercept = 0
                move = false
                lastGravity = Gravity.NO_GRAVITY
                downEvent = PointF(ev.rawX, ev.rawY)
                lastEvent = PointF(ev.rawX, ev.rawY)
                if (canMove()) {
                    handle.postDelayed(onMoveStart, 300)
                }
                Log.i("FloatMenuView", "onInterceptTouchEvent: down $downEvent")
            }

            MotionEvent.ACTION_MOVE -> checkIntercept(ev)
        }
        return intercept > 0
    }


    fun checkSwipe(ev: MotionEvent): Int {
        val dx = ev.rawX - downEvent.x
        val dy = ev.rawY - downEvent.y
        val gx = if (dx >= 0) Gravity.RIGHT else Gravity.LEFT
        val gy = if (dy >= 0) Gravity.BOTTOM else Gravity.TOP
        val g =
            if (dx.absoluteValue >= dy.absoluteValue && canSwipe(gx)) {
                gx
            } else if (dx.absoluteValue < dy.absoluteValue && canSwipe(gy)) {
                gy
            } else Gravity.NO_GRAVITY
        val up = ev.action == MotionEvent.ACTION_UP
        if (g != Gravity.NO_GRAVITY && (g != lastGravity || up)) {
            onSwipe(g, up)
        }
        lastGravity = g
        return g
    }

    fun checkMove(ev: MotionEvent) {
        val dx = ev.rawX - lastEvent.x
        val dy = ev.rawY - lastEvent.y
        lastEvent = PointF(ev.rawX, ev.rawY)
        onMove(dx.toInt(), dy.toInt(), ev.action == MotionEvent.ACTION_UP)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        ev ?: return false
        if (!checkIntercept(ev) && (ev.action == MotionEvent.ACTION_UP || ev.action == MotionEvent.ACTION_MOVE)) {
            if (intercept == 1) checkSwipe(ev) else if (intercept == 2) checkMove(ev)
        }
        return intercept > 0
    }

    fun checkIntercept(ev: MotionEvent): Boolean {
        if (intercept == 0 && ev.action == MotionEvent.ACTION_MOVE) {
            val diffY = (ev.rawY - downEvent.y).absoluteValue
            val diffX = (ev.rawX - downEvent.x).absoluteValue
            if (diffY >= 2 || diffX >= 2) {
                handle.removeCallbacks(onMoveStart)
                //仅在边缘点下才需要拦截
                intercept = if (checkSwipe(ev) == Gravity.NO_GRAVITY) -1 else 1
                move = true
                Log.i("FloatMenuView", "onInterceptTouchEvent: move intercept = ${intercept > 0}")
                return true
            }
        }
        return false
    }


    fun animate(view: View, gone: View) {
        view.visibility = GONE
        gone.visibility = VISIBLE
        gone.startAnimation(AlphaAnimation(1f, 0f).also {
            it.duration = 300
            it.setAnimationListener(object : AnimationListener {
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    gone.visibility = GONE
                    view.visibility = VISIBLE
                    view.startAnimation(AlphaAnimation(0f, 1f).also { it.duration = 300 })
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
        })
    }
}


