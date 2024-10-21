package com.clubin.com.ui.fragment.eventdetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R

class RatingAdapter(val mContext: Context) : RecyclerView.Adapter<RatingAdapter.ViewHolder>() {

    val inflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.custom_row_event_detail_review, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}