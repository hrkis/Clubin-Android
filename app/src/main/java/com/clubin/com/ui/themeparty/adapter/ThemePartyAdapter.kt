package com.clubin.com.ui.themeparty.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.ui.themeparty.model.ThemePartyModel

class ThemePartyAdapter(val mContext: Context, val list: MutableList<ThemePartyModel>): RecyclerView.Adapter<ThemePartyAdapter.EventViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val v = inflater.inflate(R.layout.custom_row_party_theme, parent, false)
        return EventViewHolder(v)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
//        return list.size
        return 10
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val eventBgImage = itemView.findViewById<ImageView>(R.id.eventBgImage)
        val dateText = itemView.findViewById<AppCompatTextView>(R.id.dateText)
        val distanceText = itemView.findViewById<AppCompatTextView>(R.id.distanceText)
        val partyName = itemView.findViewById<AppCompatTextView>(R.id.partyName)
        val organizerName = itemView.findViewById<AppCompatTextView>(R.id.organizerName)
        val ratingTxt = itemView.findViewById<AppCompatTextView>(R.id.ratingTxt)
        val concertButton = itemView.findViewById<CardView>(R.id.concertButton)
        val personImage = itemView.findViewById<CardView>(R.id.personImage)

    }
}