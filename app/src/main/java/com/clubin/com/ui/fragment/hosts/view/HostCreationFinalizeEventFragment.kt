package com.clubin.com.ui.fragment.hosts.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clubin.com.R
import com.clubin.com.databinding.HostCreationFinalizeEventFragmentBinding
import com.clubin.com.ui.fragment.eventdetail.view.EventDetailFragment
import com.clubin.com.ui.fragment.hosts.viewmodel.HostCreationFinalizeEventViewModel
import com.clubin.com.ui.tabbar.TabBarActivity
import java.lang.Exception

class HostCreationFinalizeEventFragment : Fragment(), View.OnClickListener {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    private lateinit var vm: HostCreationFinalizeEventViewModel
    private lateinit var binding: HostCreationFinalizeEventFragmentBinding
    var saveEventDisable = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@HostCreationFinalizeEventFragment).get(HostCreationFinalizeEventViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.host_creation_finalize_event_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayOf(binding.backBtn, binding.closeBtn, binding.saveEventRow, binding.previewButton).forEach { it.setOnClickListener(this) }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.backBtn -> {
                (activity as TabBarActivity)?.let { it.removeFragment() }
            }
            binding.closeBtn -> {
                (activity as TabBarActivity)?.let { it.removeFragment() }
            }
            binding.previewButton -> {
                (activity as TabBarActivity)?.let {
                    val frag = EventDetailFragment()
                    frag.showHeaderButtons = false
                    frag.showAdPreview = true
                    it.addFragment(frag, false)
                }
            }
            binding.saveEventRow -> {
                if (saveEventDisable) {
                    saveEventDisable = false
                    binding.saveEventRow.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
                    binding.saveEventTxt.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                    binding.saveEventValueTxt.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                    binding.toggleImage.setColorFilter(ContextCompat.getColor(mContext, R.color.green))

                } else {
                    saveEventDisable = true
                    binding.saveEventRow.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_red)
                    binding.saveEventTxt.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.saveEventValueTxt.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.toggleImage.setColorFilter(ContextCompat.getColor(mContext, R.color.dark_red))

                }
                binding.saveEventValueTxt.text = if (saveEventDisable) "Non" else "Oui"
            }
        }
    }
}