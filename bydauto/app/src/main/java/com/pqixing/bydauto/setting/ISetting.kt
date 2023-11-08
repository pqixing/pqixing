package com.pqixing.bydauto.setting

import android.content.Context
import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.ui.SingleItemAdapter

interface ISetting {
    fun getNameId(): Int
    fun getLayoutId(): Int
    suspend fun onBindViewHolder(viewHolder: SViewHolder)
    fun onCreate(context: Context)
    fun onDestroy(context: Context)
    fun isShow(context: Context): Boolean
}

class SViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val context = itemView.context
    val title: CheckBox? = itemView.findViewById(R.id.tv_title)
    fun <T : View> findViewById(id: Int): T {
        return itemView.findViewById(id)
    }
}

abstract class SettingImpl(val _layoutId: Int) : ISetting {
    override fun getLayoutId(): Int {
        return _layoutId
    }

    override fun onCreate(context: Context) {
    }

    override fun onDestroy(context: Context) {
    }

    override fun isShow(context: Context): Boolean {
        return App.sp.getBoolean("SHOW_${this.javaClass.simpleName}", true)
    }
}

abstract class GridSetting(val _nameId: Int) : SettingImpl(R.layout.setting_gride) {
    override fun getNameId(): Int {
        return _nameId
    }

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val recyclerView = viewHolder.findViewById<RecyclerView>(R.id.rcv_grid)
        var adapter = recyclerView.adapter as? SingleItemAdapter
        if (adapter == null) {
            adapter = SingleItemAdapter(emptyList(), R.layout.single_item_grid)
            recyclerView.adapter = adapter
        }
        onBindAdapter(viewHolder.context, adapter)
    }

    fun onBindAdapter(context: Context, adapter: SingleItemAdapter) {
        val datas = getGridDatas(context, adapter)
        val diff = DiffUtil.calculateDiff(DiffCallBack(adapter.items, datas), false)
        adapter.items = datas
        diff.dispatchUpdatesTo(adapter)
    }

    abstract fun getGridDatas(context: Context, adapter: SingleItemAdapter): List<SingleItem>


    class DiffCallBack(val olds: List<SingleItem>, val news: List<SingleItem>) : DiffUtil.Callback() {
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
            return olds[oldItemPosition] == news[newItemPosition]
        }
    }
}