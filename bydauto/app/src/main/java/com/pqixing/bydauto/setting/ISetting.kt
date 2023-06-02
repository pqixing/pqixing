package com.pqixing.bydauto.setting

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface ISetting {
    fun getLayoutId(): Int
    suspend fun onBindViewHolder(viewHolder: SViewHolder)
    fun onServiceCreate(context: Context)
    fun onServiceDestroy(context: Context)
}

class SViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val context = itemView.context
    fun <T : View> findViewById(id: Int): T {
        return itemView.findViewById(id)
    }
}

abstract class SettingImpl(val _layoutId: Int) : ISetting {
    override fun getLayoutId(): Int {
        return _layoutId
    }

    override fun onServiceCreate(context: Context) {
    }

    override fun onServiceDestroy(context: Context) {
    }

}