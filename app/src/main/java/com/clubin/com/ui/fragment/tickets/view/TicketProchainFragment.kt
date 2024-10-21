package com.clubin.com.ui.fragment.tickets.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clubin.com.ui.fragment.tickets.viewmodel.TicketProchainViewModel
import java.lang.Exception

class TicketProchainFragment: Fragment() {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    lateinit var vm: TicketProchainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@TicketProchainFragment).get(TicketProchainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}