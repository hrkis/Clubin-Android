package com.clubin.com.ui.fragment.hosts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R

class HostCreationAddressResultAdapter(val mContext: Context,
                                       val list: MutableList<String>,
                                       val listener: ItemClickListener) : RecyclerView.Adapter<HostCreationAddressResultAdapter.ViewHolder>() {

    val inflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.custom_row_host_address, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val m = list[position]
        holder.addressTxt.text = m
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addressTxt = itemView.findViewById<TextView>(R.id.addressTxt)
        init {
            itemView.setOnClickListener{
                listener.onItemClickListener(bindingAdapterPosition)
            }
        }
    }
    interface ItemClickListener{
        fun onItemClickListener(pos: Int)
    }
}