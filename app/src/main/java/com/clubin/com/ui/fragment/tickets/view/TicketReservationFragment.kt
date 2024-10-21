package com.clubin.com.ui.fragment.tickets.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.databinding.TicketReservationFragmentBinding
import com.clubin.com.ui.fragment.event.adapter.EventAdapter
import com.clubin.com.ui.fragment.event.model.EventModel
import com.clubin.com.ui.fragment.eventdetail.view.EventDetailFragment
import com.clubin.com.ui.fragment.tickets.viewmodel.TicketReservationViewModel
import com.clubin.com.ui.tabbar.TabBarActivity

class TicketReservationFragment : Fragment() {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    lateinit var vm: TicketReservationViewModel
    lateinit var binding: TicketReservationFragmentBinding

    val list: MutableList<EventModel> = mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@TicketReservationFragment).get(TicketReservationViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.ticket_reservation_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViews()
    }

    private fun setupRecyclerViews() {
        val adapter = EventAdapter(mContext, list, object : EventAdapter.EventClickListener {
            override fun onEventClick(pos: Int) {
                (activity as TabBarActivity)?.let {
                    it.addFragment(EventDetailFragment(), true)
                }
            }
        })
        binding.waitingRecycler.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.reserveRecycler.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.endedEventsRecycler.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)

        binding.waitingRecycler.adapter = adapter
        binding.reserveRecycler.adapter = adapter
        binding.endedEventsRecycler.adapter = adapter
    }
}