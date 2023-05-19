package com.pqixing.android.radar

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.pqixing.android.App
import com.pqixing.android.R

class RadarFloatView(context: Context) : FrameLayout(context) {

    val maps = listOf(
        R.id.left_front to "左前方",
        R.id.right_front to "右前方",
        R.id.left_rear to "左后方",
        R.id.right_rear to "右后方",
        R.id.left to "后左方",
        R.id.right to "后右方",
        R.id.front_left to "前左",
        R.id.front_right to "前右",
        R.id.middle_rear to "正后方"
    )

    private var views: List<TextView>
    private var setBound = false
    private var landscape = false


    private val reg = Regex("[^0-9]")
    private val C_8018F507 = Color.parseColor("#18F507")
    private val C_FFF31010 = Color.parseColor("#F31010")
    private val C_FFFFE905 = Color.parseColor("#FFE905")
    private val POS_LANDSCAPE: String = "220:260,220:660,700:260,700:680,820:360,820:580,140:400,140:560,860:480"
    private val POS_PORTRAIT: String = "900:40,900:420,1300:40,1300:420,1380:120,1380:320,820:160,820:320,1420:240"

    init {
        View.inflate(context, R.layout.radar_float, this)
        views = maps.map { findViewById(it.first) }
        resizeView(context.resources.configuration.orientation != Configuration.ORIENTATION_PORTRAIT)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        resizeView(newConfig?.orientation != Configuration.ORIENTATION_PORTRAIT)
        App.toast("onConfigurationChanged : orientation=${newConfig?.orientation} ; context=${context.resources.configuration.orientation}")

    }

    private fun resizeView(landscape: Boolean) {
        this.landscape = landscape
        val list = App.sp.getString("RADAR_FLOAT_VIEW_UI_$landscape", null)
            ?.split(",")?.takeIf { it.size > 3 }?.map { map ->
                map.split(":").let { split ->
                    (split.firstOrNull()?.toIntOrNull() ?: 0) to (split.lastOrNull()?.toIntOrNull() ?: 0)
                }
            } ?: emptyList()
        views.forEachIndexed { index, view ->
            val size = list.getOrNull(index)
            view.layoutParams = (view.layoutParams as? LayoutParams)?.also {
                it.topMargin = size?.first ?: ((index + 1) * 90)
                it.leftMargin = size?.second ?: 200
            }
        }
    }

    /**
     * 重新设置距离
     */
    fun resetBounds() {
        setBound = true
        App.toast("setBound : orientation=${context.resources.configuration.orientation}")
        this.setBackgroundColor(Color.parseColor("#55000000"))
        views.forEachIndexed { index, view -> view.text = maps[index].second }

        val save = findViewById<Button>(R.id.save)
        save.visibility = View.VISIBLE
        save.setOnClickListener {
            context.getSystemService(WindowManager::class.java).removeView(this)
            val str = views.map { it.layoutParams as? LayoutParams }
                .joinToString(",") { "${it?.topMargin ?: 0}:${it?.leftMargin ?: 0}" }
            App.sp.edit().putString("RADAR_FLOAT_VIEW_UI_$landscape", str).apply()
            App.log(str)
        }

        val clear = findViewById<Button>(R.id.clear)
        clear.visibility = View.VISIBLE
        clear.setOnClickListener {
            App.sp.edit().remove("RADAR_FLOAT_VIEW_UI_${landscape}").apply()
            App.toast("Clear : landscape=$landscape")
            resizeView(landscape)
        }
        clear.setOnLongClickListener {
            App.sp.edit().putString("RADAR_FLOAT_VIEW_UI_${landscape}", if (landscape) POS_LANDSCAPE else POS_PORTRAIT)
                .apply()
            App.toast("Reset : landscape=$landscape")
            resizeView(landscape)
            true
        }

        val cancel = findViewById<Button>(R.id.cancel)
        cancel.visibility = View.VISIBLE
        cancel.setOnClickListener {
            context.getSystemService(WindowManager::class.java).removeView(this)
        }
    }

    /**
     * left front is 150, right front is 150, left rear is 150, right rear is 150, left is 150, right is 150, front left is 150, front right is 150, middle rear radar is 150
     */
    fun parseLog(log: String?) {
        if (setBound || log == null) return
        kotlin.runCatching {
            val distanceStr = log.split("getAllRadarDistance").lastOrNull() ?: return@runCatching

//            tvLog.text = distanceStr
            val array = distanceStr.split(",")
                .map { it.replace(reg, "").toIntOrNull() ?: 150 }
                .toIntArray().takeIf { it.size >= 9 } ?: return@runCatching
//            array[8] = (array[4] + array[5]) / 2

            array.forEachIndexed { index, i ->
                views[index].text = if (i >= 150) "" else "$i cm"
                views[index].setTextColor(
                    when {
                        i >= 70 -> C_8018F507
                        i <= 40 -> C_FFF31010
                        else -> C_FFFFE905
                    }
                )
            }
        }.onFailure {
            App.log(null, it)
        }
    }
}