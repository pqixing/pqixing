package com.pqixing.bydauto.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.AppInfo
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.utils.toast

class AppAdapter(val apps: List<AppInfo>, val tag: String) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val factory = LayoutInflater.from(parent.context)
        return AppViewHolder(factory.inflate(R.layout.item_app, parent, false))
    }

    override fun getItemCount(): Int = apps.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val app = apps[position]
        holder.itemView.findViewById<ImageView>(R.id.iv_icon).setImageDrawable(app.icon)
        holder.itemView.findViewById<TextView>(R.id.tv_name).setText(app.name)
        holder.itemView.setOnClickListener {
            UiUtils.tryLaunch(it.context, app.pkg)
            UiUtils.closeFloatView(tag)
        }
        holder.itemView.setOnLongClickListener {
//            UiUtils.closeFloatView(tag)
            if (app.info.enabled) {
                "禁用${app.name}".toast()
                AdbManager.getClient().runAsync("pm disable-user --user 0 ${app.pkg}")
                app.info.enabled = false
            } else {
                "启用${app.name}".toast()
                AdbManager.getClient().runAsync("pm enable ${app.pkg}")
                app.info.enabled = true
            }
//            PopupWindow(createPopView(it.context,app),200,400).showAsDropDown(it)
            true
        }
    }

    private fun createPopView(context: Context, app: AppInfo): View {
        val content = LinearLayout(context)

        content.addView(TextView(context).also {
            it.text = "禁用"
            it.isClickable = true
            it.setOnClickListener {
                AdbManager.getClient().runAsync("pm disable-user --user 0 ${app.pkg}")
                "禁用${app.name}".toast()
            }
        })
        content.background = ColorDrawable(Color.WHITE)
        return content

    }

}

class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
