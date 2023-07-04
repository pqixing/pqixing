package com.pqixing.bydauto.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.SettingManager
import com.pqixing.bydauto.utils.UiUtils

class MainUI : BaseActivity() {

    val mainAdapter = MainAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        setContentView(R.layout.activity_settings)
        findViewById<View>(R.id.tv_title).setOnClickListener { showHideSetting() }
        val rvData = findViewById<RecyclerView>(R.id.rv_data)
        rvData.adapter = mainAdapter
        rvData.isNestedScrollingEnabled = true
        updaLayoutManager(rvData)
    }

    private fun showHideSetting() {
        val hides = SettingManager.getHides(this)
        val names = Array<CharSequence>(hides.size) { getString(hides[it].first.getNameId()) }
        val checks = BooleanArray(hides.size) { !hides[it].second }

        AlertDialog.Builder(this).setTitle(getString(R.string.main_title_add_setting))
            .setMultiChoiceItems(names, checks) { d, w, c ->
                SettingManager.hideSetting(this, hides[w].first, !c)
            }.setOnDismissListener {
                mainAdapter.setDiffData(SettingManager.updateCurSettings(this))
            }.show()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updaLayoutManager(findViewById(R.id.rv_data))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        PermType.clearCache()
        mainAdapter.setDiffData(SettingManager.updateCurSettings(this))
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


