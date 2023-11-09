package com.pqixing.bydauto.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.ISetting
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.utils.SettingManager
import com.pqixing.bydauto.utils.app
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
        val show = setting.isShow(holder.context)
        holder.title?.setText(setting.getNameId())
        holder.title?.isChecked = setting.isShow(holder.context)
        holder.title?.visibility = if (setting.showTitle(holder.context)) View.VISIBLE else View.GONE
        holder.title?.setOnCheckedChangeListener { _, show ->
            SettingManager.changeSetting(setting, show)
            app.mHandle.post { setDiffData(SettingManager.updateSettings()) }
        }
        holder.itemView.findViewById<View>(R.id.fl_content)?.visibility = if (show) View.VISIBLE else View.GONE
        if (show) App.uiScope.launch { setting.onBindViewHolder(holder) }
    }

    fun notifyDiff() = setDiffData(SettingManager.updateSettings())

    fun setDiffData(news: List<ISetting>) {
        val diff = DiffUtil.calculateDiff(DiffCallBack(datas, news), true)
        datas = news
        diff.dispatchUpdatesTo(this)
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
            return oldItemPosition == newItemPosition
        }
    }
}