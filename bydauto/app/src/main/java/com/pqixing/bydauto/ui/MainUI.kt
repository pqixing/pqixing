package com.pqixing.bydauto.ui

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.UiUtils

class MainUI : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!UiUtils.hadGrantAll(this)) {
            startActivity(Intent(this, PermissionUI::class.java))
            finish()
            return
        }

        startService(Intent(this, MainService::class.java))
        //从应用启动
        if (fromBoot()) {
            finish()
            return
        }
        setContentView(R.layout.activity_settings)
        val rvData = findViewById<RecyclerView>(R.id.rv_data)
        updaLayoutManager(rvData)
        rvData.adapter = MainAdapter(Const.settings)
        rvData.isNestedScrollingEnabled = true
    }

    private fun fromBoot() = intent.getStringExtra("from") == "boot"


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updaLayoutManager(findViewById(R.id.rv_data))
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


