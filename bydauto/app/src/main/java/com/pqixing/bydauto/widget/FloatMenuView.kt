package com.pqixing.bydauto.widget

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.graphics.PixelFormat
import android.media.AudioManager
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.CarInfo
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.model.MusicInfo
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.BYDUtils
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.utils.dp
import com.pqixing.bydauto.utils.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FloatMenuView : FrameLayout, ITouch {


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

    private val recyclerView = RecyclerView(context)
    val content = View.inflate(context, R.layout.float_menu, this).findViewById<View>(R.id.content)
    private val wms by lazy { context.getSystemService(WindowManager::class.java) }
    private val inMini: Boolean
        get() = height <= 15.dp
    private val miniHeight = 60.dp
    private val touchHelper = TouchHelper(this)
    private val seekBar = findViewById<SeekbarView>(R.id.rl_slide)

    private val heightPixels = context.resources.displayMetrics.heightPixels
    private val carInfo: CarInfo
        get() = MainService.carInfo
    private val musicInfo: MusicInfo
        get() = MainService.musicInfo

    init {
        setBackgroundResource(R.drawable.bg_float_menu_default)
        addView(View(context), LayoutParams(300.dp, 10.dp))
        seekBar.setAutoClose { seekBar.visibility = GONE }
        initMenuView()
    }

    private fun initMenuView() {

        MenuItemTouch(findViewById(R.id.sv_home)).setClick {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
        }.setGravityClick(Gravity.LEFT, R.drawable.icon_menu_back) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK)
        }.setGravityClick(Gravity.RIGHT, R.drawable.icon_menu_split) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
        }

        MenuItemTouch(findViewById(R.id.sv_apps)).setClick {

        }.setGravityClick(Gravity.LEFT, R.drawable.icon_menu_arrow_left) {
            BYDUtils.sendDiCmd("返回上个应用  ")
        }.setGravityClick(Gravity.RIGHT, R.drawable.icon_menu_fast) {
            UiUtils.fastLauch(context)
        }


        MenuItemTouch(findViewById(R.id.sv_air)).setClick {
            carInfo.ac_open.set(!it.isSelected)
        }.setGravityClick(Gravity.LEFT, R.drawable.icon_menu_wind) {
            startWinTrack()
        }.setGravityClick(Gravity.RIGHT, R.drawable.icon_menu_temp) {
            startTempTrack()
        }.also { item ->
            val updateTxt = {
                val sb = StringBuilder()
                if (carInfo.ac_control_model.get()) {
                    sb.append("A")
                }
                sb.append(carInfo.ac_wind.get())
                sb.append("-")
                sb.append(carInfo.ac_temp_main.get())
                item.singleView.name?.text = sb.toString()
            }
            carInfo.ac_open.observe { item.singleView.isSelected = it }
            carInfo.ac_control_model.observe { updateTxt() }
            carInfo.ac_wind.observe { updateTxt() }
            carInfo.ac_temp_main.observe { updateTxt() }
        }

        MenuItemTouch(findViewById(R.id.sv_soc)).setClick {
            carInfo.soc_mode.set(!carInfo.soc_mode.get())
        }.setGravityClick(Gravity.LEFT, R.drawable.icon_menu_soc_save) {
            startSocTrack()
        }.setGravityClick(Gravity.RIGHT, R.drawable.icon_menu_soc_save) {
            startSocTrack()
        }.also { item ->
            carInfo.soc_mode.observe { item.singleView.isSelected = it }
            carInfo.soc_target.observe { item.singleView.name?.text = it.toString() }
        }


        MenuItemTouch(findViewById(R.id.sv_music)).setClick {
            if (BYDAutoUtils.getCurrentAudioFocusPackage().isEmpty()) {
                BYDUtils.sendDiCmd("播放音乐")
            } else {
                postKeyEvent(if (it.isSelected) KeyEvent.KEYCODE_MEDIA_PAUSE else KeyEvent.KEYCODE_MEDIA_PLAY)
            }
        }.setGravityClick(Gravity.LEFT, android.R.drawable.ic_media_previous) {
            postKeyEvent(KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        }.setGravityClick(Gravity.RIGHT, android.R.drawable.ic_media_next) {
            postKeyEvent(KeyEvent.KEYCODE_MEDIA_NEXT)
        }.also { item ->
            musicInfo.play.observe { item.singleView.icon?.alpha = if (it) 1f else 0.5f }
            musicInfo.pkg.observe {
                UiManager.getAppInfo(it)?.icon?.run { item.singleView.icon?.setImageDrawable(this) }
            }
        }

    }

    private fun startTempTrack() {
        seekBar.visibility = VISIBLE
        seekBar.setData(
            carInfo.ac_temp_main.get().toString(),
            (17..33 step 1).map { it.toString() },
            SimpleImpl { v, p ->
                App.uiScope.launch {
                    if (carInfo.ac_separate.get()) {
                        carInfo.ac_separate.set(false)
                        delay(1000)
                    }
                    carInfo.ac_temp_main.set(p.toInt())
                }
            })
    }

    private fun startWinTrack() {
        seekBar.visibility = VISIBLE
        seekBar.setData(
            carInfo.ac_temp_main.get().toString(),
            (0..7 step 1).map { it.toString() },
            SimpleImpl { v, p ->
                if (p == "0") {
                    carInfo.ac_control_model.set(true)
                } else {
                    carInfo.ac_wind.set(p.toInt())
                }
            })
    }

    private fun postKeyEvent(keyEvent: Int) {
        val audio = context.getSystemService(AudioManager::class.java)
        audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, keyEvent))
        audio.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, keyEvent))
    }

    private fun startSocTrack() {
        var socTarget = MainService.carInfo.soc_target.get()
        val mod = socTarget % 5
        if (mod != 0) {
            socTarget -= mod
            MainService.carInfo.soc_target.set(socTarget)
        }
        seekBar.visibility = VISIBLE
        seekBar.setData(
            socTarget.toString(),
            (25..70 step 5).map { it.toString() },
            SimpleImpl { v, p ->
                MainService.carInfo.soc_target.set(p.toInt())
            })
    }


    override fun requestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept)
        touchHelper.requestDisallowInterceptTouchEvent(disallowIntercept)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return touchHelper.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return touchHelper.onTouchEvent(event)
    }

    override fun canMove(): Boolean {
        isSelected = true
        return true
    }

    override fun canSwipe(gravity: Int): Boolean {
        return gravity == Gravity.TOP || gravity == Gravity.BOTTOM
    }

    override fun onClick() {
    }

    override fun onReset() {
        isPressed = false
        isSelected = false
    }

    override fun onMove(dx: Int, dy: Int, up: Boolean) {
        Log.i("FloatMenuView", "onMove: $dx  $dy $up")
        val p = layoutParams as WindowManager.LayoutParams
        p.x += dx
        if (!inMini) {
            p.y += dy
        }
        wms.updateViewLayout(this, p)
        Const.SP_FLOAT_MENU_LOCATION = "${p.x},${p.y}"
    }

    override fun onSwipe(gravity: Int, up: Boolean) {
        isPressed = true
        val location = IntArray(2)
        getLocationOnScreen(location)
        val mini =
            (gravity == Gravity.TOP && location[1] < miniHeight) || (gravity == Gravity.BOTTOM && (heightPixels - location[1]) < miniHeight)
        if (up) {
            if (inMini || mini) changeMode(!inMini, gravity) else openFull(gravity)
        }
    }

    private fun openFull(gravity: Int) {
        "打开更大页面".toast()
    }


    private fun changeMode(mini: Boolean, gravity: Int) {
        onReset()
        val params = layoutParams as WindowManager.LayoutParams
        if (mini) {
            content.visibility = View.GONE
            params.y = if (gravity == Gravity.TOP) 0 else heightPixels * 2
        } else {
            val location = IntArray(2)
            getLocationOnScreen(location)
            params.y = location[1]
            content.visibility = View.VISIBLE
            Const.SP_FLOAT_MENU_LOCATION = "${params.x},${params.y}"
        }
        wms.updateViewLayout(this, params)
    }

    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()
    }

    private fun createParams(): WindowManager.LayoutParams {

        val locations = Const.SP_FLOAT_MENU_LOCATION.split(",").map { it.toIntOrNull() }
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.WRAP_CONTENT
            it.height = WindowManager.LayoutParams.WRAP_CONTENT
            it.format = PixelFormat.RGBA_8888
            it.horizontalMargin = 0f
            it.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.gravity = Gravity.START or Gravity.TOP
            it.x = locations.getOrNull(0) ?: 0
            it.y = locations.getOrNull(1) ?: 0
            it.alpha = 1f
        }
    }

    class MenuItemTouch(val singleView: SingleView) : ITouch {
        val iconId: Int = singleView.getIconId()
        private val maps = hashMapOf<Int, Pair<Int, View.OnClickListener>>()

        init {
            singleView.setTouchHelper(TouchHelper(this))
            singleView.setBackgroundResource(R.drawable.bg_float_item_press)
        }

        fun setGravityClick(gravity: Int, resId: Int = 0, click: View.OnClickListener): MenuItemTouch {
            maps[gravity] = resId to click
            return this
        }

        fun setClick(click: OnClickListener): MenuItemTouch {
            maps[Gravity.NO_GRAVITY] = iconId to click
            return this
        }

        override fun onReset() {
            super.onReset()
            singleView.isPressed = false
            singleView.icon?.setImageResource(iconId)
            singleView.name?.visibility = View.VISIBLE
            singleView.tip?.visibility = View.VISIBLE
        }

        override fun onDown() {
            super.onDown()
            singleView.isPressed = true
        }

        override fun canMove(): Boolean {
            return false
        }

        override fun canSwipe(gravity: Int): Boolean {
            return true
        }

        override fun onClick() {
            maps[Gravity.NO_GRAVITY]?.second?.onClick(singleView)
        }

        override fun onSwipe(gravity: Int, up: Boolean) {
            super.onSwipe(gravity, up)
            if (up) {
                maps[gravity]?.second?.onClick(singleView)
            } else {
                singleView.name?.visibility = View.INVISIBLE
                singleView.tip?.visibility = View.INVISIBLE
                val icon = maps[gravity]?.first ?: 0
                if (icon != 0) singleView.icon?.setImageResource(icon)
            }
        }
    }
}


