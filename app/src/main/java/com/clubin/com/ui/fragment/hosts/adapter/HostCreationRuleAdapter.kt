package com.clubin.com.ui.fragment.hosts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R


class HostCreationRuleAdapter(val mContext: Context,
                              val list: MutableList<String>,
                              val listener: ItemClickListener) :
    RecyclerView.Adapter<HostCreationRuleAdapter.ViewHolder>() {

    val inflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.custom_row_host_rule, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var rule: String = list[position];
        holder.ruleTV.text = rule

    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ruleTV = itemView.findViewById<TextView>(R.id.name)

        init {
            itemView.setOnClickListener {
                listener.onItemClickListener(bindingAdapterPosition)
            }
        }
    }

    interface ItemClickListener {
        fun onItemClickListener(pos: Int)
    }
}
