package com.clubin.com.ui.fragment.eventdetail.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.databinding.EventDetailFragmentBinding
import com.clubin.com.ui.fragment.eventdetail.adapter.PersonGoingAdapter
import com.clubin.com.ui.fragment.eventdetail.adapter.RatingAdapter
import com.clubin.com.ui.fragment.eventdetail.adapter.SliderAdapter
import com.clubin.com.ui.fragment.eventdetail.model.PersonGoingEventModel
import com.clubin.com.ui.fragment.eventdetail.viewmodel.EventDetailViewModel
import com.clubin.com.ui.tabbar.TabBarActivity
import java.lang.Exception

class EventDetailFragment : Fragment(), View.OnClickListener {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    private lateinit var vm: EventDetailViewModel
    lateinit var binding: EventDetailFragmentBinding

    val personGoingEventList: MutableList<PersonGoingEventModel> = mutableListOf()
    var personGoingAdapter: PersonGoingAdapter? = null
    var ratingAdapter: RatingAdapter? = null
    private val sliderAdapter: SliderAdapter by lazy {
        SliderAdapter(mContext)
    }
    var showHeaderButtons = true
    var showAdPreview = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@EventDetailFragment).get(EventDetailViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.event_detail_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayOf(binding.closeBtn, binding.shareBtn, binding.postBtn).forEach { it.setOnClickListener(this) }
        binding.closeBtn.isVisible = showHeaderButtons
        binding.shareBtn.isVisible = showHeaderButtons

        binding.shareBtn.isVisible = !showAdPreview
        binding.postBtn.isVisible = showAdPreview


        personGoingEventList.add(PersonGoingEventModel("Paris", R.drawable.dummy_person))
        personGoingEventList.add(PersonGoingEventModel("Alex", R.drawable.dummy_person_1))
        personGoingEventList.add(PersonGoingEventModel("Annie", R.drawable.dummy_person_2))

        personGoingAdapter = PersonGoingAdapter(mContext, personGoingEventList)
        binding.goingPersonRecyclerView.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.goingPersonRecyclerView.adapter = personGoingAdapter

        ratingAdapter = RatingAdapter(mContext)
        binding.ratingRecyclerView.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.ratingRecyclerView.adapter = ratingAdapter

        binding.imageSlider.apply {
            setSliderAdapter(this@EventDetailFragment.sliderAdapter)
            startAutoCycle()
        }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.closeBtn -> {
                (activity as TabBarActivity).removeFragment()
            }
            binding.shareBtn -> {

            }
            binding.postBtn -> {

            }
        }
    }
}