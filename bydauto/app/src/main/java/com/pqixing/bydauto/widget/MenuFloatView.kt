package com.pqixing.bydauto.widget

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.PointF
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.ui.MainUI
import com.pqixing.bydauto.utils.UiUtils
import kotlin.math.absoluteValue

class MenuFloatView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private val content = inflate(context, R.layout.float_menu, this).findViewById<LinearLayout>(R.id.content)
    private var menus = content.findViewById<LinearLayout>(R.id.menus)
    private var other = content.findViewById<ViewGroup>(R.id.fl_others)
    private val touchBar: View = View(context).also {
        it.setBackgroundColor(Color.YELLOW)
        it.visibility = View.INVISIBLE
        addView(it, LayoutParams(UiUtils.dp2dx(5), LayoutParams.MATCH_PARENT))
    }

    init {
        content.visibility = View.GONE
        isClickable = true
        minimumWidth = UiUtils.dp2dx(10)
        listOf(

            TouchBarContentView.BarItem("返回", R.drawable.icon_menu_back) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK)
            },
            TouchBarContentView.BarItem("桌面", R.drawable.icon_menu_home) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
            },
            TouchBarContentView.BarItem("最近", R.drawable.icon_menu_recent) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
            },
            TouchBarContentView.BarItem("分屏", R.drawable.icon_menu_split) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
            },
            TouchBarContentView.BarItem("全屏", R.drawable.icon_menu_full) {
                UiUtils.switchFullScreen(context, !Const.SP_FULL_SCREEN)
            },
            TouchBarContentView.BarItem("应用", R.drawable.icon_menu_app) {
                UiUtils.showOrUpdate(ApplicationView.FLOAT_TAG) { ApplicationView(context) }
            },
            TouchBarContentView.BarItem("设置", R.drawable.icon_menu_setting) {
                UiUtils.tryLaunch(context, Intent(context, MainUI::class.java))
            }
        ).forEach {
            menus.addView(
                TouchBarContentView.BarView(context).setBarItem(it),
                LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0, it.weight.toFloat())
            )
        }
    }

    private var close = Runnable {
        content.visibility = View.GONE
        if (other.childCount > 0) {
            other.removeAllViews()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        handleTouchEvent(ev)
        return super.dispatchTouchEvent(ev)
    }

    private fun handleTouchEvent(ev: MotionEvent) {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                touchBar.visibility = if (!isOpen()) VISIBLE else INVISIBLE
                removeCallbacks(close)
                intercept = 0
                downEvent = PointF(ev.x, ev.y)
            }

            MotionEvent.ACTION_MOVE -> {
                if (intercept == 0) {
                    val diffY = (ev.y - (downEvent?.y ?: 0f)).absoluteValue
                    val diffX = (ev.x - (downEvent?.x ?: 0f)).absoluteValue
                    if (diffY >= 2 || diffX >= 2) {
                        intercept = if (diffY < diffX || !isOpen()) 1 else -1
                    }
                }
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                touchBar.visibility = INVISIBLE
                postDelayed(close, Const.SP_DELAY_DISMISS)
                if (intercept == 1) {
                    val diffX = ev.x - (downEvent?.x ?: 0f)
                    val open =
                        (layoutDirection == LAYOUT_DIRECTION_LTR && diffX > 0) || (layoutDirection == LAYOUT_DIRECTION_RTL && diffX < 0)
                    content.visibility = if (open) VISIBLE else GONE
                }
                downEvent = null
            }
        }
    }

    private var intercept = 0
    private var downEvent: PointF? = null

    private fun isOpen(): Boolean = content.visibility == View.VISIBLE
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return intercept == 1
    }

    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()
    }

    private fun createParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.WRAP_CONTENT
            it.height = WindowManager.LayoutParams.MATCH_PARENT
            it.format = PixelFormat.RGBA_8888
            it.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.gravity =
                if (layoutDirection == LAYOUT_DIRECTION_LTR) Gravity.START or Gravity.CENTER_VERTICAL else Gravity.END or Gravity.CENTER_VERTICAL
            it.alpha = 1f
        }
    }

    fun setDirection(direction: Int, group: ViewGroup = this) {
        if (group == this || group is LinearLayout) {
            group.layoutDirection = direction
        }
        for (i in 0 until group.childCount) {
            val child = group.getChildAt(i)
            if (child is ViewGroup) {
                setDirection(direction, child)
            }
        }
    }
}