package com.pqixing.bydauto.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.ISetting
import com.pqixing.bydauto.setting.SViewHolder
import kotlinx.coroutines.launch

class MainAdapter(var datas: List<ISetting>) : RecyclerView.Adapter<SViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val baseRoot = inflater.inflate(R.layout.setting_base, parent, false) as ViewGroup
        return SViewHolder(inflater.inflate(viewType, baseRoot, true))
    }

    override fun getItemViewType(position: Int): Int {
        return datas[position].getLayoutId()
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: SViewHolder, position: Int) {
        val setting = datas.getOrNull(position) ?: return
        holder.title?.setText(setting.getNameId())
        App.uiScope.launch { setting.onBindViewHolder(holder) }
    }
}