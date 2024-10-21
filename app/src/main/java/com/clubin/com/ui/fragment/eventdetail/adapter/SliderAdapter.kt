package com.clubin.com.ui.fragment.eventdetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.clubin.com.R
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(val context: Context) : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    val inflater = LayoutInflater.from(context)
    val imagesArray = arrayOf(R.drawable.party, R.drawable.cocktail, R.drawable.party, R.drawable.cocktail)

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = inflater.inflate(R.layout.custom_row_event_detail_slider, parent, false)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.sliderImage.setImageResource(imagesArray[position])
    }

    override fun getCount(): Int {
        return 4
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        val sliderImage: ImageView = itemView.findViewById(R.id.sliderImage)
    }

}