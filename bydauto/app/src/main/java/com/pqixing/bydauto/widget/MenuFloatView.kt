package com.pqixing.bydauto.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PixelFormat
import android.graphics.PointF
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.AppInfo
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.model.ItemFactory
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.ui.SingleItemAdapter
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
        context, attrs, defStyleAttr
    )


    private val content = inflate(context, R.layout.float_menu, this).findViewById<LinearLayout>(R.id.content)
    private var controls = content.findViewById<LinearLayout>(R.id.ll_control)
    private val touchBar: View = View(context).also {
        it.setBackgroundColor(context.getColor(android.R.color.holo_blue_light))
        it.visibility = View.INVISIBLE
        addView(it, LayoutParams(UiUtils.dp2dx(5), LayoutParams.MATCH_PARENT))
    }
    private val notifyListeners = mutableListOf<NotifyListener>()
    private val autoInfo = AutoInfo(this)
    private var appAdapter: SingleItemAdapter

    init {
        content.visibility = View.GONE
        isClickable = true
        minimumWidth = UiUtils.dp2dx(10)
        SingleItemAdapter(ItemFactory.createMenus(autoInfo), R.layout.single_item_tint)
            .register(R.id.menus, "soc_", listOf(1))
        SingleItemAdapter(ItemFactory.createAc(autoInfo), R.layout.single_item_ac_state)
            .register(R.id.rcv_ac_state, "ac_")

        SingleItemAdapter(ItemFactory.createWinds(autoInfo), R.layout.single_item_text)
            .register(R.id.rcv_ac_wind, "ac_wind")
        SingleItemAdapter(ItemFactory.createTemps(autoInfo), R.layout.single_item_text)
            .register(R.id.rcv_ac_temp, "ac_temp")
        appAdapter = SingleItemAdapter(emptyList(), R.layout.single_item_app).register(R.id.rcv_apps)

        findViewById<ViewGroup>(R.id.rl_music_content).layoutDirection = View.LAYOUT_DIRECTION_LTR
        initMediaButton()
    }


    private fun SingleItemAdapter.register(redId: Int, prefix: String? = null, targets: List<Int> = emptyList()): SingleItemAdapter {
        findViewById<RecyclerView>(redId)?.adapter = this
        if (prefix != null) {
            notifyListeners.add(AdapterNotify(prefix, this, targets))
        }

        return this
    }

    fun reverse() = layoutDirection == View.LAYOUT_DIRECTION_RTL
    private fun initMediaButton() {
        content.findViewById<ImageView>(R.id.iv_music_icon).setOnClickListener {
            UiUtils.tryLaunch(it.context, UiUtils.getMusicPkg())
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


    }


    private var close = Runnable {
        for (i in 0 until content.childCount) {
            content.getChildAt(i).visibility = View.GONE
        }
        content.visibility = View.GONE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        autoInfo.onAttach()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        autoInfo.onDetach()
    }

    fun open(openAc: Boolean) {
        content.visibility = View.VISIBLE
        for (i in 0 until content.childCount) {
            val child = content.getChildAt(i)
            if (child.visibility != View.VISIBLE) {
                child.visibility = View.VISIBLE
                break
            }
        }
        if (openAc) {
            controls.visibility = View.VISIBLE
        }
        if (controls.visibility == VISIBLE) {
            update()
        }
        (findViewById<RecyclerView>(R.id.menus).layoutManager as LinearLayoutManager).scrollToPositionWithOffset(1, 0)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update() = kotlin.runCatching {
        App.get().uiScope.launch {
            autoInfo.exeLoad { App.log("loadData ${it}") }

            val apps = withContext(Dispatchers.IO) {
                UiManager.getAppInfo().filter { it.launch }.sortedBy { it.system }.map { info ->
                    SingleItem(info.name, 0, info.icon) {
                        UiUtils.tryLaunch(context, info.pkg)
                    }.also { it.obj = info }
                }
            }
            val pkg = UiUtils.getMusicPkg()
            val icon = apps.find { (it.obj as AppInfo).pkg == pkg }?.drawable
            if (icon != null) {
                content.findViewById<ImageView>(R.id.iv_music_icon).setImageDrawable(icon)
            }

            appAdapter.items = apps
            appAdapter.notifyDataSetChanged()

        }
    }

    fun notifyAcControl(notify: Set<String>) = post {
        notifyListeners.filter { notify.any { n -> it.handle(n) } }.forEach { it.notifyData() }
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
                downTs = System.currentTimeMillis()
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
                    if (open) open(diffX.absoluteValue > diff || System.currentTimeMillis() - downTs > 500) else close.run()
                }
                downEvent = null
                downTs = -1L
            }
        }
    }

    private var diff: Int = UiUtils.dp2dx(64)
    private var intercept = 0
    private var downEvent: PointF? = null
    private var downTs: Long = -1L

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
            it.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
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


    class AdapterNotify(val prefix: String, val adapter: RecyclerView.Adapter<*>, val targets: List<Int> = emptyList()) :
        NotifyListener {
        override fun handle(type: String): Boolean {
            return type.isEmpty() || type.startsWith(prefix)
        }

        override fun notifyData() {
            if (targets.isEmpty()) {
                adapter.notifyDataSetChanged()
            } else {
                targets.forEach { adapter.notifyItemChanged(it) }
            }
        }
    }

    interface NotifyListener {
        fun handle(type: String): Boolean
        fun notifyData()
    }

}


