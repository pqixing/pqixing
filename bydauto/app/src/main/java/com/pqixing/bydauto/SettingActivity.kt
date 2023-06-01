package com.pqixing.bydauto

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.setting.ISetting
import com.pqixing.bydauto.setting.SViewHolder

class SettingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!Settings.canDrawOverlays(this)) kotlin.runCatching {
            val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.parse("package:${packageName}"))
            startActivity(i)
        }
        //从应用启动
        if (intent.getStringExtra("from") == "boot") {
            finish()
            return
        }
        startService(Intent(this, MainService::class.java))
        setContentView(R.layout.activity_settings)

        val rvData = findViewById<RecyclerView>(R.id.rv_data)

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvData.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        } else {
            rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
        rvData.adapter = SettingAdapter(Const.settings)
    }


    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("SettingActivity", "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("SettingActivity", "enforceCallingPermission: ")
    }
}


class SettingAdapter(val datas: Array<ISetting>) : RecyclerView.Adapter<SViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SViewHolder {
        return SViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        return datas[position].getLayoutId()
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: SViewHolder, position: Int) {
        val setting = datas.getOrNull(position) ?: return
        setting.onBindViewHolder(holder)
    }
}
