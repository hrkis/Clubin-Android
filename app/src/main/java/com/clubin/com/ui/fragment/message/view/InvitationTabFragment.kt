package com.clubin.com.ui.fragment.message.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.clubin.com.R
import com.clubin.com.databinding.InvitationTabFragmentBinding
import com.clubin.com.ui.fragment.message.adapter.InvitationTabEventAdapter
import com.clubin.com.ui.fragment.message.adapter.InvitationTabFriendRequestAdapter
import com.clubin.com.ui.fragment.message.model.InvitationTabModel
import com.clubin.com.ui.fragment.message.viewmodel.InvitationTabViewModel
import java.lang.Exception

class InvitationTabFragment : Fragment() {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    private lateinit var vm: InvitationTabViewModel
    private lateinit var binding: InvitationTabFragmentBinding

    val list: MutableList<InvitationTabModel> = mutableListOf()

    var eventAdapter: InvitationTabEventAdapter? = null
    var requestAdapter: InvitationTabFriendRequestAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity.run {
            ViewModelProvider(this@InvitationTabFragment).get(InvitationTabViewModel::class.java)
        } ?: throw Exception("Invalid activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.invitation_tab_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.add(InvitationTabModel())
        list.add(InvitationTabModel())

        eventAdapter = InvitationTabEventAdapter(mContext, list)
        binding.eventRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.eventRecyclerView.adapter = eventAdapter


        requestAdapter = InvitationTabFriendRequestAdapter(mContext, list)
        binding.friendRequestRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.friendRequestRecyclerView.adapter = requestAdapter

    }

}