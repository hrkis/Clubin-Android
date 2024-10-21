package com.clubin.com.ui.fragment.tickets.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.clubin.com.R
import com.clubin.com.databinding.TicketsMainFragmentBinding
import com.clubin.com.ui.fragment.eventdetail.view.EventDetailFragment
import com.clubin.com.ui.fragment.tickets.viewmodel.TicketViewModel
import java.lang.Exception

class TicketsMainFragment: Fragment(), View.OnClickListener {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    lateinit var binding: TicketsMainFragmentBinding
    lateinit var vm: TicketViewModel
    val activeTabColor: Int by lazy { ContextCompat.getColor(mContext, R.color.white) }
    val inactiveTabColor: Int by lazy { ContextCompat.getColor(mContext, R.color.dull_white) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@TicketsMainFragment).get(TicketViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.tickets_main_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayOf(binding.prochainTab, binding.reservationTab, binding.annulerBtn, binding.shareBtn).forEach { it.setOnClickListener(this) }

        binding.prochainTab.performClick()
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.prochainTab -> {
                binding.prochainTabDivider.visibility = View.VISIBLE
                binding.reservationTabDivider.visibility = View.INVISIBLE

                binding.prochainTabTxt.setTextColor(activeTabColor)
                binding.reservationTabTxt.setTextColor(inactiveTabColor)

                binding.btnContainer.isVisible = true

                val frag = EventDetailFragment()
                frag.showHeaderButtons = false

                addFragment(frag, false)
            }
            binding.reservationTab -> {
                binding.prochainTabDivider.visibility = View.INVISIBLE
                binding.reservationTabDivider.visibility = View.VISIBLE

                binding.prochainTabTxt.setTextColor(inactiveTabColor)
                binding.reservationTabTxt.setTextColor(activeTabColor)

                binding.btnContainer.isVisible = false

                addFragment(TicketReservationFragment(), false)
            }
        }
    }

    public fun addFragment(frag: Fragment, addToBackStack: Boolean) {

        val trans = childFragmentManager.beginTransaction()

        if (addToBackStack) {
            trans.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_right, R.anim.slide_in_from_right, R.anim.slide_out_to_right)
            trans.add(R.id.ticketsMainContainer, frag)
        } else {
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            trans.replace(R.id.ticketsMainContainer, frag)
        }

        if (addToBackStack) trans.addToBackStack(frag::class.java.simpleName)

        trans.commit()
        childFragmentManager.executePendingTransactions()
    }

    fun removeFragment() {
        if (childFragmentManager.backStackEntryCount > 0) {
            childFragmentManager.popBackStackImmediate()
            val v = currentFragment()
            //noinspection ConstantConditions
            if (childFragmentManager.backStackEntryCount > 0) {
                v?.view?.requestFocus()
            }
        }
    }

    fun currentFragment(): Fragment? {
        return childFragmentManager.findFragmentById(R.id.ticketsMainContainer)
    }
}