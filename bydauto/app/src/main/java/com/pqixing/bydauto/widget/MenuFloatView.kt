package com.pqixing.bydauto.widget

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.PointF
import android.hardware.bydauto.ac.BYDAutoAcDevice
import android.media.AudioManager
import android.util.AttributeSet
import android.view.Gravity
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.ui.MainUI
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.ui.SingleItemAdapter
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.BYDUtils
import com.pqixing.bydauto.utils.UiManager
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
    private var menus = content.findViewById<RecyclerView>(R.id.menus)
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
        SingleItemAdapter(menuItems()).attach(menus)
        initControl()
    }

    private fun reverseLayout() = layoutDirection == View.LAYOUT_DIRECTION_RTL
    private fun initControl() {
        content.findViewById<View>(R.id.btn_music_open).setOnClickListener {
            UiUtils.tryLaunch(it.context, UiUtils.getDefualtMusic())
        }
        content.findViewById<View>(R.id.btn_music_next).setOnClickListener {
            val audio = context.getSystemService(AudioManager::class.java)
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT))
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT))
        }
        content.findViewById<View>(R.id.btn_music_pre).setOnClickListener {
            val audio = context.getSystemService(AudioManager::class.java)
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS))
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PREVIOUS))
        }
        content.findViewById<View>(R.id.btn_music_play).setOnClickListener {
            val audio = context.getSystemService(AudioManager::class.java)
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE))
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE))
        }
        content.findViewById<View>(R.id.btn_music_play).setOnLongClickListener {
            val audio = context.getSystemService(AudioManager::class.java)
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY))
            audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY))
            true
        }
        val apps = UiManager.getAppInfo().filter { !it.system }.map { infos ->
            SingleItem(infos.name, R.drawable.icon_menu_home) {
                UiUtils.tryLaunch(context, infos.pkg)
            }
        }
        var adapter = SingleItemAdapter(apps)
        content.findViewById<RecyclerView>(R.id.rcv_apps).also {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, reverseLayout())
        }

        val acs = listOf(
            SingleItem("开关", R.drawable.icon_menu_back) {
                val acControl = BYDAutoUtils.getAcControl()
                val open = acControl.acStartState == BYDAutoAcDevice.AC_POWER_ON
                if (open) {
                    acControl.stop(BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY)
                } else {
                    acControl.start(BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY)
                }
            }.update {
                val acControl = BYDAutoUtils.getAcControl()
                val open = acControl.acStartState == BYDAutoAcDevice.AC_POWER_ON
                it.select = open

            },
            SingleItem("内循环", R.drawable.icon_menu_back) {
                val acControl = BYDAutoUtils.getAcControl()
                val open = acControl.acCycleMode == BYDAutoAcDevice.AC_CYCLEMODE_INLOOP
                acControl.setAcCycleMode(
                    BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY,
                    if (open) BYDAutoAcDevice.AC_CYCLEMODE_OUTLOOP else BYDAutoAcDevice.AC_CYCLEMODE_INLOOP
                )
            }.update {
                val acControl = BYDAutoUtils.getAcControl()
                val open = acControl.acCycleMode == BYDAutoAcDevice.AC_CYCLEMODE_INLOOP
                it.select = open

            },
            SingleItem("SOC", R.drawable.icon_menu_setting) {

            }.also {
                it.onUpdate = {
                    val setting = BYDAutoUtils.getSetting()
                    it.name = "SOC(${setting.socConfig}) : ${setting.socTarget}"
                }
            }
        )

        adapter = SingleItemAdapter(acs)
        content.findViewById<RecyclerView>(R.id.rcv_ac_state).also {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, reverseLayout())
        }


    }

    private fun menuItems() = listOf(
        SingleItem("返回", R.drawable.icon_menu_back) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK)
        },
        SingleItem("桌面", R.drawable.icon_menu_home) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
        },
        SingleItem("最近", R.drawable.icon_menu_recent) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
        },
        SingleItem("分屏", R.drawable.icon_menu_split) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
        },
        SingleItem("对换", R.drawable.icon_menu_split) {
            BYDUtils.sendDiCmd("左右屏幕互换")
        },
        SingleItem("全屏", R.drawable.icon_menu_full) {
            UiUtils.switchFullScreen(context, !Const.SP_FULL_SCREEN)
        },
        SingleItem("关屏", R.drawable.icon_menu_app) {
            BYDUtils.sendDiCmd("关闭屏幕")
        },
        SingleItem("应用", R.drawable.icon_menu_app) {
            UiUtils.showOrUpdate(ApplicationView.FLOAT_TAG) { ApplicationView(context) }
        },
        SingleItem("SOC", R.drawable.icon_menu_setting) {

        }.also {
            it.onUpdate = {
                val setting = BYDAutoUtils.getSetting()
                it.name = "SOC(${setting.socConfig}) : ${setting.socTarget}"
            }
        },
        SingleItem("空调", R.drawable.icon_menu_setting) {

        }.also {
            it.onUpdate = {
                val acControl = BYDAutoUtils.getAcControl()
                val open = acControl.acStartState == BYDAutoAcDevice.AC_POWER_ON
                it.name = "空调：(${if (open) "开" else "关"}:风${acControl.acWindLevel} }"
            }
        },
        SingleItem("设置", R.drawable.icon_menu_setting) {
            UiUtils.tryLaunch(context, Intent(context, MainUI::class.java))
        },
    )

    private var close = Runnable {
        for (i in 0 until content.childCount) {
            content.getChildAt(i).visibility = View.GONE
        }
        content.visibility = View.GONE
        if (other.childCount > 0) {
            other.removeAllViews()
        }
        removeCallbacks(update)
    }

    fun open() {
        content.visibility = View.VISIBLE
        update.run()
        for (i in 0 until content.childCount) {
            val child = content.getChildAt(i)
            if (child.visibility != View.VISIBLE) {
                child.visibility = View.VISIBLE
                return
            }
        }
    }

    fun update() = kotlin.runCatching {
        menus.adapter?.notifyDataSetChanged()

    }

    private var update = object : Runnable {
        override fun run() {
            removeCallbacks(this)
            update()
            postDelayed(this, 1000)
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
                    if (open) open() else close.run()
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