package com.pqixing.bydauto.widget

import android.graphics.PointF
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

class TouchHelper(val listener: ITouch) : ITouch by listener {


    private var lastGravity = Gravity.NO_GRAVITY
    private var downEvent: PointF = PointF(0f, 0f)
    private var lastEvent: PointF = PointF(0f, 0f)

    //0 未处理，-1 不拦截， 1 拦截普通事件，2 拦截长按拖动事件
    private var intercept: Int = 0
    private val handle = Handler(Looper.getMainLooper())
    private val onMoveStart = Runnable {
        if (canMove()) {
            intercept = 2;
            onMove(0, 0, false)
        }
    }

    fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        ev ?: return false
        Log.i("TouchHelper", "onInterceptTouchEvent: ${ev.action}")
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                onDown()
                handle.removeCallbacks(onMoveStart)
                intercept = 0
                lastGravity = Gravity.NO_GRAVITY
                downEvent = PointF(ev.rawX, ev.rawY)
                lastEvent = PointF(ev.rawX, ev.rawY)
                handle.postDelayed(onMoveStart, 300)
            }

            MotionEvent.ACTION_MOVE -> checkIntercept(ev)
            MotionEvent.ACTION_UP -> {
                handle.removeCallbacks(onMoveStart)
            }

            MotionEvent.ACTION_CANCEL -> {
                handle.removeCallbacks(onMoveStart)
                onReset()
            }
        }
        return intercept > 0
    }

    fun onTouchEvent(ev: MotionEvent?): Boolean {
        ev ?: return false
        when (ev.action) {
            MotionEvent.ACTION_MOVE -> {
                checkIntercept(ev)
                if (intercept == 1) checkSwipe(ev) else if (intercept == 2) checkMove(ev)
            }

            MotionEvent.ACTION_UP -> {
                handle.removeCallbacks(onMoveStart)
                if (intercept == 1) checkSwipe(ev) else if (intercept == 2) checkMove(ev) else if ((ev.rawX - downEvent.x).absoluteValue <= 10 && (ev.rawY - downEvent.y) <= 10) onClick()
                onReset()
            }

            MotionEvent.ACTION_CANCEL -> {
                handle.removeCallbacks(onMoveStart)
                onReset()
            }
        }
        return true
    }


    private fun checkSwipe(ev: MotionEvent): Int {
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

    private fun checkMove(ev: MotionEvent) {
        val dx = ev.rawX - lastEvent.x
        val dy = ev.rawY - lastEvent.y
        lastEvent = PointF(ev.rawX, ev.rawY)
        onMove(dx.roundToInt(), dy.roundToInt(), ev.action == MotionEvent.ACTION_UP)
    }


    private fun checkIntercept(ev: MotionEvent) {
        if (intercept == 0 && ev.action == MotionEvent.ACTION_MOVE) {
            val diffY = (ev.rawY - downEvent.y).absoluteValue
            val diffX = (ev.rawX - downEvent.x).absoluteValue
            if (diffY >= 5 || diffX >= 5) {
                handle.removeCallbacks(onMoveStart)
                //仅在边缘点下才需要拦截
                intercept = if (checkSwipe(ev) == Gravity.NO_GRAVITY) -1 else 1
                Log.i("TouchHelper", "onInterceptTouchEvent: move intercept = ${intercept > 0}")
            }
        }
    }

    fun requestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        if (disallowIntercept) {
            handle.removeCallbacks(onMoveStart)
            onReset()
        }
    }

}

interface ITouch {
    fun canMove(): Boolean = false
    fun canSwipe(gravity: Int): Boolean = false
    fun onMove(dx: Int, dy: Int, up: Boolean) {}
    fun onSwipe(gravity: Int, up: Boolean) {}
    fun onClick() {}
    fun onReset() {}
    fun onDown(){}
}

