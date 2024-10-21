package com.clubin.com.ui.fragment.message.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.ui.fragment.message.model.MessageTabModel

class MessageTabAdapter(val mContext: Context, val list: MutableList<MessageTabModel>) : RecyclerView.Adapter<MessageTabAdapter.ViewHolder>() {

    val inflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.custom_row_message_tab, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val m = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imgView)
        val titleTxt: TextView = itemView.findViewById(R.id.titleTxt)
        val descriptionTxt: TextView = itemView.findViewById(R.id.descriptionTxt)
    }

}