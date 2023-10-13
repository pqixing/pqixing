package com.pqixing.bydauto.widget

import android.accessibilityservice.AccessibilityService
import android.annotation.SuppressLint
import android.content.ComponentName
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
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.AppInfo
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.ui.MainUI
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.ui.SingleItemAdapter
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.BYDUtils
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    private var controls = content.findViewById<LinearLayout>(R.id.ll_control)
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

    private val acInfo = AcInfo(this)

    fun reverseLayout() = layoutDirection == View.LAYOUT_DIRECTION_RTL
    private fun initControl() {
        content.findViewById<ImageView>(R.id.iv_music_icon).setOnClickListener {
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
            if (BYDAutoUtils.getCurrentAudioFocusPackage().isEmpty()) {
                BYDUtils.sendDiCmd("播放音乐")
            }
        }

        acAdapter = SingleItemAdapter(acItems(), R.layout.single_item_ac_state)
        content.findViewById<RecyclerView>(R.id.rcv_ac_state).adapter = acAdapter

        val winds = (1..7).toList().map { i ->
            SingleItem("$i") {
                BYDAutoUtils.getAcControl().setAcWindLevel(BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY, i)
                acInfo.wind = i
                acInfo.loadData()
            }.update {
                it.select = acInfo.wind == i
            }
        }
        windAdapter = SingleItemAdapter(winds, R.layout.single_item_text)
        content.findViewById<RecyclerView>(R.id.rcv_ac_wind).adapter = windAdapter

        val temps = (17..33).toList().map { i ->
            SingleItem(if (i == 17) "Lo" else if (i == 33) "Hi" else i.toString()) {
                val acControl = BYDAutoUtils.getAcControl()
                val type = when {
                    !acInfo.separate -> BYDAutoAcDevice.AC_TEMPERATURE_MAIN_DEPUTY
                    else -> if (reverseLayout()) BYDAutoAcDevice.AC_TEMPERATURE_DEPUTY else BYDAutoAcDevice.AC_TEMPERATURE_MAIN
                }
                acControl.setAcTemperature(
                    type,
                    i,
                    BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY,
                    BYDAutoAcDevice.AC_TEMPERATURE_UNIT_OC
                )
                acInfo.wind = i
                acInfo.loadData()
            }.update {
                it.select = acInfo.temp == i
            }
        }
        tempAdapter = SingleItemAdapter(temps, R.layout.single_item_text)
        content.findViewById<RecyclerView>(R.id.rcv_ac_temp).also {
            it.adapter = tempAdapter
            it.scrollToPosition(4)
        }

        appAdapter = SingleItemAdapter(emptyList(), R.layout.single_item_app)
        content.findViewById<RecyclerView>(R.id.rcv_apps).adapter = appAdapter
    }

    private fun acItems() = listOf(
        SingleItem("空调", R.drawable.icon_menu_ac_open) {
            if (acInfo.open) {
                BYDAutoUtils.getAcControl().stop(BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY)
            } else {
                BYDAutoUtils.getAcControl().start(BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY)
            }
            acInfo.open = !acInfo.open
            acInfo.loadData()
        }.update { it.select = acInfo.open },
        SingleItem("内循环", R.drawable.icon_menu_ac_inloop) {
            val acControl = BYDAutoUtils.getAcControl()
            val open = acControl.acCycleMode == BYDAutoAcDevice.AC_CYCLEMODE_INLOOP
            acControl.setAcCycleMode(
                BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY,
                if (open) BYDAutoAcDevice.AC_CYCLEMODE_OUTLOOP else BYDAutoAcDevice.AC_CYCLEMODE_INLOOP
            )
            acInfo.inLoop = !open
            acInfo.loadData()
        }.update {
            it.name = if (acInfo.inLoop) "内循环" else "外循环"
            it.select = acInfo.inLoop
            it.icon = if (acInfo.inLoop) R.drawable.icon_menu_ac_inloop else R.drawable.icon_menu_ac_outloop
        },
        SingleItem("更多", R.drawable.icon_menu_ac_more) {
            val intent = Intent().setComponent(
                ComponentName("com.byd.airconditioning", "com.byd.airconditioning.mainactivity.FullScreenMainActivity")
            )
            UiUtils.tryLaunch(it.context, intent)
            close.run()
        },
    )

    private fun menuItems() = listOf(

        SingleItem("下拉", R.drawable.icon_menu_arrow_down) {
            AdbManager.getClient().runAsync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
        },
        SingleItem("地图|音乐", R.drawable.icon_menu_app) {
            UiUtils.fastLauch(it.context)
        },
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

        SingleItem("互换", R.drawable.icon_menu_change) {
            BYDUtils.sendDiCmd("左右屏幕互换")
        },

        SingleItem("全屏", R.drawable.icon_menu_full) {
            UiUtils.switchFullScreen(context, !Const.SP_FULL_SCREEN)
        },
        SingleItem("锁屏", R.drawable.icon_menu_lock) {
            BYDUtils.sendDiCmd("关闭屏幕")
        },

        SingleItem("设置", R.drawable.icon_menu_setting) {
            UiUtils.tryLaunch(context, Intent(context, MainUI::class.java))
        },
        SingleItem("通知", R.drawable.icon_menu_notify) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
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
    }

    fun open() {
        content.visibility = View.VISIBLE
        for (i in 0 until content.childCount) {
            val child = content.getChildAt(i)
            if (child.visibility != View.VISIBLE) {
                child.visibility = View.VISIBLE
                break
            }
        }
        if (controls.visibility == VISIBLE) {
            update()
        }
    }

    lateinit var appAdapter: SingleItemAdapter
    lateinit var acAdapter: SingleItemAdapter
    lateinit var windAdapter: SingleItemAdapter
    lateinit var tempAdapter: SingleItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    fun update() = kotlin.runCatching {
        acInfo.loadData(0)
        App.get().uiScope.launch {
            val apps = withContext(Dispatchers.IO) {
                UiManager.getAppInfo().filter { it.launch }.sortedBy { it.system }.map { info ->
                    SingleItem(info.name, 0, info.icon) {
                        UiUtils.tryLaunch(context, info.pkg)
                    }.also { it.obj = info }
                }
            }
            val pkg = BYDAutoUtils.getCurrentAudioFocusPackage()
            val icon = apps.find { (it.obj as AppInfo).pkg == pkg }?.drawable
            if (icon != null) {
                content.findViewById<ImageView>(R.id.iv_music_icon).setImageDrawable(icon)
            }

            appAdapter.items = apps
            appAdapter.notifyDataSetChanged()

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun notifyAcControl() {
        acAdapter.notifyDataSetChanged()
        windAdapter.notifyDataSetChanged()
        tempAdapter.notifyDataSetChanged()
//        kotlin.runCatching {
//            content.findViewById<RecyclerView>(R.id.rcv_ac_temp).smoothScrollToPosition((17..33).indexOf(acInfo.temp))
//        }
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
