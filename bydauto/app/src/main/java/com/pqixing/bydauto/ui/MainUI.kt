package com.pqixing.bydauto.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.UiUtils

class MainUI : BaseActivity() {

    val mainAdapter = MainAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        setContentView(R.layout.activity_settings)
        val rvData = findViewById<RecyclerView>(R.id.rv_data)
        rvData.adapter = mainAdapter
        rvData.isNestedScrollingEnabled = true
        updaLayoutManager(rvData)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updaLayoutManager(findViewById(R.id.rv_data))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        PermType.clearCache()
        val news = Const.getSettings(this)
        val olds = mainAdapter.datas
        news.minus(olds).forEach { it.onCreate(this) }
        olds.minus(news).forEach { it.onDestroy(this) }
        mainAdapter.datas = news
        mainAdapter.notifyDataSetChanged()
    }

    private fun updaLayoutManager(rvData: RecyclerView?) {
        rvData ?: return
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE && UiUtils.inSplitMode(this)) {
            rvData.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        } else {
            rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }
}


