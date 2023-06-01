package com.pqixing.bydauto.setting

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ISetting {
    fun getName(): String
    fun getLayoutId(): Int
    fun onBindViewHolder(viewHolder: SViewHolder)
    fun onServiceCreate(context: Context)
    fun onServiceDestroy(context: Context)
}

class SViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

abstract class SettingImpl(val name: String) : ISetting {
    override fun getName(): String {
        return name
    }

    override fun onServiceCreate(context: Context) {
    }

    override fun onServiceDestroy(context: Context) {
    }

}