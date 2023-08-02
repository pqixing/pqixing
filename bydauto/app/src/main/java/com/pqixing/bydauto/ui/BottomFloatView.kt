package com.pqixing.bydauto.ui

import android.accessibilityservice.AccessibilityService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.utils.UiUtils

class BottomFloatView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

//    var bottomFloatHeight: Int = UiUtils.dp2dx(100)

    private var touch: TouchBarContentView
    private var content: LinearLayout

    init {
        inflate(context, R.layout.ui_bottom_float, this)
        touch = findViewById(R.id.ll_touch_bar)
        content = findViewById(R.id.fl_content)

        initTouch()
        initContent()
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
        content.findViewById<View>(R.id.btn_ac_temp_18).setOnClickListener {
            UiUtils.sendDiCmd("温度18")
        }
        content.findViewById<View>(R.id.btn_ac_temp_20).setOnClickListener { UiUtils.sendDiCmd("温度20") }
        content.findViewById<View>(R.id.btn_ac_temp_23).setOnClickListener { UiUtils.sendDiCmd("温度23") }
        content.findViewById<View>(R.id.btn_ac_temp_24).setOnClickListener { UiUtils.sendDiCmd("温度24") }
        content.findViewById<View>(R.id.btn_ac_temp_25).setOnClickListener { UiUtils.sendDiCmd("温度25") }
        content.findViewById<View>(R.id.btn_ac_temp_26).setOnClickListener { UiUtils.sendDiCmd("温度26") }

        content.findViewById<View>(R.id.btn_map_open).setOnClickListener { UiUtils.sendDiCmd("打开地图") }
        content.findViewById<View>(R.id.btn_map_home).setOnClickListener { UiUtils.sendDiCmd("导航 回家") }
        content.findViewById<View>(R.id.btn_map_company).setOnClickListener { UiUtils.sendDiCmd("导航 公司") }
        content.findViewById<View>(R.id.btn_map_address_1)
            .setOnClickListener { UiUtils.sendDiCmd("导航 深圳市粤海街道后海村") }

    }

    private fun initTouch() {
        val items = listOf(
            TouchBarContentView.BarItem("导航栏") {
                content.visibility =
                    if (content.visibility == VISIBLE) GONE else VISIBLE
            },
            TouchBarContentView.BarItem("最近", 2) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
            },
            TouchBarContentView.BarItem("主页", 3) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
            },
            TouchBarContentView.BarItem("最近", 2) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
            },
            TouchBarContentView.BarItem("导航栏") {
                content.visibility =
                    if (content.visibility == VISIBLE) GONE else VISIBLE
            },
        )
        touch.setItems(items)
    }
}