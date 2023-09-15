package com.pqixing.bydauto.widget

import android.content.Context
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.ui.AppAdapter
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils

class ApplicationView : FrameLayout {
    companion object {
        const val FLOAT_TAG = "FLOAT_TAG_APPLICATION"
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val apps = RecyclerView(context)

    init {
        isClickable = true
        setOnClickListener { UiUtils.closeFloatView(FLOAT_TAG) }
        apps.setOnClickListener { }
        apps.setBackgroundResource(R.drawable.bg_item_rect_color)

        addView(apps, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT).also {
            val margin = UiUtils.dp2dx(60)
            it.topMargin = margin
            it.bottomMargin = margin
            it.leftMargin = margin
            it.rightMargin = margin
        })
        apps.layoutManager = GridLayoutManager(
            context,
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 8 else 4,
            GridLayoutManager.VERTICAL,
            false
        )
        val infos = UiManager.getAppInfo().sortedBy { it.system || !it.info.enabled }
        apps.adapter = AppAdapter(infos, FLOAT_TAG)
    }

    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()
    }

    private fun createParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.MATCH_PARENT
            it.height = WindowManager.LayoutParams.MATCH_PARENT
            it.format = PixelFormat.RGBA_8888
            it.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        }
    }
}