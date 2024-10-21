package com.clubin.com.ui.fragment.profile.views

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.clubin.com.R
import com.clubin.com.databinding.UserEventListFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.event.model.EventModel
import com.clubin.com.ui.fragment.profile.adapter.UserEventAdapter
import com.clubin.com.ui.fragment.profile.callbacks.ContactUsFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class UserEventListFragment : BaseDataBindingFragment<UserEventListFragmentDataBinding>
    (R.layout.fragment_user_event_list),
    ContactUsFragmentCallback {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    val list: MutableList<EventModel> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun injectDaggerComponent() {

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserEventListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
        setAdapter();
    }

    private fun setAdapter() {
        val adapter = UserEventAdapter(mContext, list)
        var layoutManager = GridLayoutManager(mContext, 2)

        binding.viewRecycler.layoutManager = layoutManager
        binding.viewRecycler.adapter = adapter
    }
}

