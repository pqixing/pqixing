package com.pqixing.bydauto.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.ISetting
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingHelper
import kotlinx.coroutines.launch

class MainAdapter(var datas: List<ISetting>) : RecyclerView.Adapter<SViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val baseRoot = inflater.inflate(R.layout.setting_base, parent, false) as ViewGroup
        inflater.inflate(viewType, baseRoot.findViewById(R.id.fl_content), true)
        return SViewHolder(baseRoot)
    }

    override fun getItemViewType(position: Int): Int {
        return datas[position].getLayoutId()
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: SViewHolder, position: Int) {
        val setting = datas.getOrNull(position) ?: return
        holder.title?.setText(setting.getNameId())
        holder.title?.setOnLongClickListener {
            SettingHelper.hideSetting(holder.context, setting, true)
            setDiffData(SettingHelper.updateCurSettings(holder.context))
            true
        }
        App.uiScope.launch { setting.onBindViewHolder(holder) }
    }

    fun setDiffData(news: List<ISetting>) {
        DiffUtil.calculateDiff(DiffCallBack(datas, news), false).dispatchUpdatesTo(this)
        datas = news
    }

    class DiffCallBack(val olds: List<ISetting>, val news: List<ISetting>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return olds.size
        }

        override fun getNewListSize(): Int {
            return news.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return olds[oldItemPosition] == news[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return false
        }
    }
}