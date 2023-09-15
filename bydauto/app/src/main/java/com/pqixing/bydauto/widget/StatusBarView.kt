package com.pqixing.bydauto.widget

import android.accessibilityservice.AccessibilityService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
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
import android.widget.TextView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.ActionCASExe
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.service.LaunchCASExe
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class StatusBarView : FrameLayout, UiManager.IActivityLife {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val root = inflate(context, R.layout.ui_status_bar_float, this)
    private val touch: TouchBarContentView = findViewById(R.id.ll_touch_bar)
    private val content: LinearLayout = findViewById(R.id.fl_content)


    private val timeFormat = SimpleDateFormat("HH:mm MM-dd E", Locale.CHINESE)
    private val tvTime: TextView = findViewById(R.id.tv_bar_time)

    private var dimiss = object : Runnable {
        override fun run() {
            removeCallbacks(this)
            content.visibility = View.GONE
        }
    }
    private var time = object : Runnable {
        override fun run() {
            removeCallbacks(this)
            val newText = timeFormat.format(Date())
            if (newText != tvTime.text) {
                tvTime.text = newText
            }
            postDelayed(this, 1000)
        }
    }
    private var inlaunch = true


    init {
        initTouch()
        initBar()
        initContent()

    }

    private fun initBar() {
        time.run()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        UiManager.addCallBack(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        UiManager.removeCallBack(this)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        removeCallbacks(dimiss)
        if (!inlaunch && (ev?.action == MotionEvent.ACTION_UP || ev?.action == MotionEvent.ACTION_CANCEL)) {
            updateContentState(false)
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun initContent() {
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


        content.findViewById<View>(R.id.btn_ac_toggle).setOnClickListener {
            val intent = Intent().setComponent(
                ComponentName(
                    "com.byd.airconditioning",
                    "com.byd.airconditioning.mainactivity.FullScreenMainActivity"
                )
            )
            UiUtils.tryLaunch(it.context, intent)
        }
        content.findViewById<View>(R.id.btn_ac_temp_cycle).setOnClickListener {
            val txt = (it as TextView).text.trim().toString()
            val newTxt = if (txt == "外循环") "内循环" else "外循环"
            it.text = newTxt
            UiUtils.sendDiCmd(newTxt)
        }
        content.findViewById<View>(R.id.btn_ac_temp_18).setOnClickListener { UiUtils.sendDiCmd("温度18") }
        content.findViewById<View>(R.id.btn_ac_temp_20).setOnClickListener { UiUtils.sendDiCmd("温度20") }
        content.findViewById<View>(R.id.btn_ac_temp_23).setOnClickListener { UiUtils.sendDiCmd("温度23") }
        content.findViewById<View>(R.id.btn_ac_temp_24).setOnClickListener { UiUtils.sendDiCmd("温度24") }
        content.findViewById<View>(R.id.btn_ac_temp_25).setOnClickListener { UiUtils.sendDiCmd("温度25") }
        content.findViewById<View>(R.id.btn_ac_temp_26).setOnClickListener { UiUtils.sendDiCmd("温度26") }

        content.findViewById<View>(R.id.btn_menu_set).setOnClickListener {
            AdbManager.getClient().runAsync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
        }
        content.findViewById<View>(R.id.btn_menu_fast).setOnClickListener {
            val musicPkg = UiUtils.getDefualtMusic()
            if (UiManager.inSplitMode && UiManager.isResumePkg("com.byd.automap")
                && UiManager.isResumePkg(musicPkg)
            ) {
                UiUtils.sendDiCmd("左右互换")
            } else CAService.performs(
                ActionCASExe(AccessibilityService.GLOBAL_ACTION_HOME) to 0L,
                LaunchCASExe("com.byd.automap") to 1000L,
                ActionCASExe(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) to 1000L,
                LaunchCASExe(musicPkg) to 1000L,
            )
        }
        content.findViewById<View>(R.id.btn_menu_split)
            .setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) }

    }

    private fun updateContentState(show: Boolean) {
        if (show && content.visibility != VISIBLE) {
            content.visibility = View.VISIBLE
        }

        if (!show && content.visibility == View.VISIBLE) {
            postDelayed(dimiss, 5000)
        }

    }

    private fun initTouch() {
        val items = listOf(
            TouchBarContentView.BarItem("快捷设置") {
                AdbManager.getClient().runAsync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
            },
            TouchBarContentView.BarItem("菜单", 4) {
                removeCallbacks(dimiss)
                content.visibility =
                    if (content.visibility == VISIBLE) GONE else VISIBLE
            },
            TouchBarContentView.BarItem("通知栏") {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
            },
        )
        touch.setItems(items, R.drawable.bg_bar_item_status_bar)
    }


    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()
    }

    fun createParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.MATCH_PARENT
            it.height = WindowManager.LayoutParams.WRAP_CONTENT
            it.format = PixelFormat.RGBA_8888
            it.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            it.alpha = 1f
        }
    }

    override fun onPkgResume(pkg: String?, ac: String) {
        inlaunch = "com.android.launcher3" == pkg
        updateContentState(inlaunch)
    }
}