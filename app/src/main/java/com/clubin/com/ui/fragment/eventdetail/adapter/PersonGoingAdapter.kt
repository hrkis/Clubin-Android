package com.clubin.com.ui.fragment.eventdetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.ui.fragment.eventdetail.model.PersonGoingEventModel

class PersonGoingAdapter(val mContext: Context, val list: MutableList<PersonGoingEventModel>) : RecyclerView.Adapter<PersonGoingAdapter.ViewHolder>() {

    val inflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.custom_row_event_detail_person, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val m = list[position]
        holder.personImage.setImageResource(m.image)
        holder.personName.text = m.name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personImage : ImageView = itemView.findViewById(R.id.personImage)
        val personName : TextView = itemView.findViewById(R.id.personName)
    }
}