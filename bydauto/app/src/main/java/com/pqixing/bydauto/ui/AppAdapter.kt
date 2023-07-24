package com.pqixing.bydauto.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.AppInfo
import com.pqixing.bydauto.utils.UiUtils

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
    }

}

class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
