package com.clubin.com.ui.fragment.hosts.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clubin.com.R
import com.clubin.com.databinding.HostCreationPeopleFragmentBinding
import com.clubin.com.ui.fragment.hosts.viewmodel.HostCreationPeopleViewModel
import com.clubin.com.ui.tabbar.TabBarActivity

class HostCreationPeopleFragment : Fragment(), View.OnClickListener {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    private lateinit var vm: HostCreationPeopleViewModel
    lateinit var binding: HostCreationPeopleFragmentBinding
    private var peopleCount: Int? = 2
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@HostCreationPeopleFragment).get(HostCreationPeopleViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.host_creation_people_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayOf(binding.backBtn, binding.closeBtn, binding.continueBtn,
            binding.ivAdd, binding.ivRemove).forEach { it.setOnClickListener(this) }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.backBtn,
            binding.closeBtn -> {
                (activity as TabBarActivity).let {
                    it.removeFragment()
                }
            }
            binding.continueBtn -> {
                (activity as TabBarActivity).let {
                    it.addFragment(HostCreationAddressFragment(), true)
                }
            }
            binding.ivAdd -> {
                if (peopleCount!! < 10) {
                    peopleCount = peopleCount!! + 1
                }
                binding.placesNumTxt.text = peopleCount.toString()
            }
            binding.ivRemove -> {
                if (peopleCount!! > 2) {
                    peopleCount = peopleCount!! - 1
                }
                binding.placesNumTxt.text = peopleCount.toString()
            }
        }
    }
}