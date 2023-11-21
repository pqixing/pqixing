package com.pqixing.bydauto.widget

import android.content.Context
import android.graphics.PixelFormat
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.widget.FrameLayout
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.ItemFactory
import com.pqixing.bydauto.ui.SingleItemAdapter
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.utils.dp
import kotlin.math.absoluteValue

class HTouchView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, layoutDirection: Int) : super(context) {
        setLayoutDirection(layoutDirection)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

    }


    private val content = inflate(context, R.layout.float_h_touch, this).findViewById<ViewGroup>(R.id.content)
    private val menusMin = content.findViewById<RecyclerView>(R.id.rcv_menu_min)
    private val menusMax = content.findViewById<RecyclerView>(R.id.rcv_menu_max)
    private val cards = content.findViewById<RecyclerView>(R.id.rcv_max_card)

    private val revert: Boolean by lazy { layoutDirection == View.LAYOUT_DIRECTION_RTL }


    private val diff = 40.dp
    private var downEvent: PointF = PointF(-1f, -1f)
    private var intercept = 0

    private var minMenuAdapter = SingleItemAdapter(ItemFactory.minMenus(), R.layout.single_item_icon)
    private var maxMenuAdapter = SingleItemAdapter(ItemFactory.maxMenus(), R.layout.single_item_icon)

    //模式 0,不可见，1，菜单可见，2菜单和卡片可见
    private var xMode = 0

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        menusMin.adapter = minMenuAdapter
        menusMax.adapter = maxMenuAdapter
        switchMenuMode(false)
        switchXMode(1)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        ev ?: return false
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                intercept = 0
                downEvent = PointF(ev.x, ev.y)
                Log.i("HTouchView", "onInterceptTouchEvent: down $downEvent")
            }

            MotionEvent.ACTION_MOVE -> {
                if (intercept == 0) {
                    val diffY = (ev.y - downEvent.y).absoluteValue
                    val diffX = (ev.x - downEvent.x).absoluteValue
                    if (diffY >= 2 || diffX >= 2) {
                        //仅在边缘点下才需要拦截
                        intercept = if ((downEvent.x - (if (revert) right else left)).absoluteValue <= diff) 1 else -1
                        Log.i("HTouchView", "onInterceptTouchEvent: move intercept = ${intercept == 1}")
                    }
                }
            }
        }
        return intercept == 1
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        ev ?: return false
        if (ev.action == MotionEvent.ACTION_UP) {
            val diffY = (ev.y - downEvent.y)
            val diffX = (ev.x - downEvent.x)
            if (diffY.absoluteValue > diffX.absoluteValue) {
                switchMenuMode(diffY > 0)
            } else {
                val m = if ((diffX >= 0 && !revert) || (diffX < 0 && revert)) 1 else -1

                switchXMode(xMode + m)
            }
        }
        return intercept == 1
    }

    /**
     * 切换横向菜单模式
     */
    private fun switchXMode(mode: Int) {
        //如果已经是全展开模式，再展开则关闭
        val real = if (mode > 2) 1 else mode
        xMode = real
//        if(bar.visibility == View.VISIBLE)
        content.children.forEachIndexed { index, view ->
            view.visibility = if (index < real) View.VISIBLE else View.GONE
        }
    }

    /**
     * 切换纵向菜单模式
     */
    private fun switchMenuMode(down: Boolean) {
        if (down) UiUtils.pullStatusBar() else {
            val min = menusMax.visibility == View.VISIBLE
            menusMin.visibility = View.VISIBLE
            menusMax.visibility = View.VISIBLE
            if (min) animate(menusMin, menusMax) else animate(menusMax, menusMin)

        }
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

    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()
    }

    private fun createParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.WRAP_CONTENT
            it.height = WindowManager.LayoutParams.WRAP_CONTENT
            it.format = PixelFormat.RGBA_8888
            it.horizontalMargin = 0f
            it.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.gravity =
                if (!revert) Gravity.START or Gravity.BOTTOM else Gravity.END or Gravity.BOTTOM
            it.alpha = 1f
        }
    }
}


