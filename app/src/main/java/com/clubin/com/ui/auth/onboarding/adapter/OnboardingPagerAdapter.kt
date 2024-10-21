package com.clubin.com.ui.auth.onboarding.adapter

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.clubin.com.R
import com.clubin.com.ui.auth.onboarding.model.ViewPagerDM


class OnboardingPagerAdapter(context: Context, pagerList:ArrayList<ViewPagerDM>): PagerAdapter() {
    internal var context: Context
    internal var pager:ArrayList<ViewPagerDM>

    init{
        this.context = context
        this.pager = pagerList
    }
    override fun isViewFromObject(view: View, o:Any):Boolean {
        return view === o
    }
    override fun instantiateItem(container: ViewGroup, position:Int):Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_pager_item, container, false)

        val imageView = view.findViewById(R.id.iv_onboarding) as ImageView
        val mainContainer = view.findViewById(R.id.mainContainer) as ConstraintLayout
        val heading1 = view.findViewById(R.id.tv_heading) as TextView
        val heading2 = view.findViewById(R.id.tv_text) as TextView
        val center_heading = view.findViewById(R.id.center_heading) as TextView
        pager[position].image?.let { imageView.setBackgroundResource(it) }
        heading1.text = pager[position].text1 ?: ""
        heading2.text = pager[position].text2 ?: ""
      /*  if(position==pager.size-1)
        {
            center_heading.visibility=View.VISIBLE
            heading1.visibility=View.INVISIBLE
            heading2.visibility=View.INVISIBLE
        }
        else{
            center_heading.visibility=View.INVISIBLE
            heading1.visibility=View.VISIBLE
            heading2.visibility=View.VISIBLE
        }*/
        val gd = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                ContextCompat.getColor(context, pager.get(position).startColor!!),
            ContextCompat.getColor(context, pager.get(position).endColor!!))
        )
        gd.cornerRadius = 0f
        mainContainer.background = gd
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position:Int, `object`:Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return pager.size
    }

    override fun getItemPosition(`object`:Any):Int {
        return super.getItemPosition(`object`)
    }
}