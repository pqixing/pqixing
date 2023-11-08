package com.pqixing.bydauto.ui

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.R

data class SingleItem(var name: String, var icon: Int = 0, var drawable: Drawable? = null, var select: Boolean = false, val click: View.OnClickListener? = null) {
    companion object {
        val empty = SingleItem("")
    }

    var onUpdate: ((item: SingleItem) -> Unit)? = null
    var obj: Any? = null
    fun update(update: (item: SingleItem) -> Unit): SingleItem {
        this.onUpdate = update
        return this
    }
}

class SingleItemAdapter(var items: List<SingleItem>, val resId: Int) :
    RecyclerView.Adapter<SingleItemAdapter.ViewHolder>() {

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
        holder.icon.isSelected = item.select
        holder.name.isSelected = item.select
        holder.itemView.setOnClickListener {
            kotlin.runCatching {
                item.click?.onClick(it)
            }
            kotlin.runCatching {
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

