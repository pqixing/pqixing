package com.pqixing.bydauto.ui

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.R

data class SingleItem(var name: String, var icon: Int = 0, var drawable: Drawable? = null, val click: View.OnClickListener) {
    var select = false
    var onUpdate: ((item: SingleItem) -> Unit)? = null

    fun update(update: (item: SingleItem) -> Unit): SingleItem {
        this.onUpdate = update
        return this
    }
}

class SingleItemAdapter(val items: List<SingleItem>, val resId: Int = R.layout.single_item_tint) :
    RecyclerView.Adapter<SingleItemAdapter.ViewHolder>() {
    fun attach(recyclerView: RecyclerView) {
        recyclerView.adapter = this
//        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, LinearLayout.HORIZONTAL))
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val factory = LayoutInflater.from(parent.context)
        return ViewHolder(factory.inflate(resId, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        kotlin.runCatching {
            item.onUpdate?.invoke(item)
        }
        if (item.icon != 0) {
            holder.icon.setImageResource(item.icon)
        }
        if (item.drawable != null) {
            holder.icon.setImageDrawable(item.drawable)
        }
        holder.name.text = item.name
        holder.itemView.isSelected = item.select
        holder.itemView.setOnClickListener {
            kotlin.runCatching {
                item.click.onClick(it)
                item.onUpdate?.invoke(item)
            }
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.findViewById<ImageView>(R.id.iv_icon)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
    }

}

