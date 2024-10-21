package com.clubin.com.ui.fragment.event.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R

class EventLocationTimeAdapterDisable(
        val mContext: Context,
        val list: MutableList<String>,
        val listener: ItemClickListener) : RecyclerView.Adapter<EventLocationTimeAdapterDisable.ViewHolder>() {

        val inflater = LayoutInflater.from(mContext)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = inflater.inflate(R.layout.custom_row_location_time_disable, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //    val m = list[position]

        }

        override fun getItemCount(): Int {
            //  return list.size
            return 1
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val addressTxt = itemView.findViewById<TextView>(R.id.addressTxt)

            init {
                itemView.setOnClickListener {
                    // listener.onItemClickListener(bindingAdapterPosition)
                }
            }
        }

        interface ItemClickListener {
            fun onItemClickListener(pos: Int)
        }
    }
