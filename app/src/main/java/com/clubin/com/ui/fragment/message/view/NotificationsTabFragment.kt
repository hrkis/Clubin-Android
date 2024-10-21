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
import com.clubin.com.databinding.NotificationTabFragmentBinding
import com.clubin.com.ui.fragment.message.adapter.NotificationTabInfoAdapter
import com.clubin.com.ui.fragment.message.adapter.NotificationTabReviewAdapter
import com.clubin.com.ui.fragment.message.model.NotificationTabModel
import com.clubin.com.ui.fragment.message.viewmodel.NotificationTabViewModel
import java.lang.Exception

class NotificationsTabFragment : Fragment() {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    private lateinit var vm: NotificationTabViewModel
    private lateinit var binding: NotificationTabFragmentBinding

    var reviewAdapter: NotificationTabReviewAdapter? = null
    var infoAdapter: NotificationTabInfoAdapter? = null
    val list: MutableList<NotificationTabModel> = mutableListOf()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@NotificationsTabFragment).get(NotificationTabViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.notification_tab_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.add(NotificationTabModel())
        list.add(NotificationTabModel())

        reviewAdapter = NotificationTabReviewAdapter(mContext, list)
        binding.reviewRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.reviewRecyclerView.adapter = reviewAdapter

        infoAdapter = NotificationTabInfoAdapter(mContext, list)
        binding.infoRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.infoRecyclerView.adapter = infoAdapter
    }
}