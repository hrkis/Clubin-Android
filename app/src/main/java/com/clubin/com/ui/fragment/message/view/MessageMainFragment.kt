package com.clubin.com.ui.fragment.message.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.clubin.com.R
import com.clubin.com.databinding.MessageMainFagmentBinding
import com.clubin.com.ui.fragment.event.view.EventFragment
import com.clubin.com.ui.fragment.message.viewmodel.MessageMainViewModel
import com.clubin.com.ui.tabbar.TabBarActivity

class MessageMainFragment : Fragment(), View.OnClickListener {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    lateinit var binding: MessageMainFagmentBinding
    private lateinit var vm: MessageMainViewModel

    val activeTabColor: Int by lazy { ContextCompat.getColor(mContext, R.color.white) }
    val inactiveTabColor: Int by lazy { ContextCompat.getColor(mContext, R.color.dull_white) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@MessageMainFragment).get(MessageMainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.message_main_fagment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayOf(binding.messagesTab, binding.invitationTab, binding.notificationsTab, binding.chartIcon).forEach { it.setOnClickListener(this) }

        binding.messagesTab.performClick()
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.messagesTab -> {
                binding.messagesTabDivider.visibility = View.VISIBLE
                binding.invitationTabDivider.visibility = View.INVISIBLE
                binding.notificationsTabDivider.visibility = View.INVISIBLE

                binding.messageTabTxt.setTextColor(activeTabColor)
                binding.invitationTabTxt.setTextColor(inactiveTabColor)
                binding.notificationTabTxt.setTextColor(inactiveTabColor)

                addFragment(MessageTabFragment(), false)
            }
            binding.invitationTab -> {
                binding.messagesTabDivider.visibility = View.INVISIBLE
                binding.invitationTabDivider.visibility = View.VISIBLE
                binding.notificationsTabDivider.visibility = View.INVISIBLE

                binding.messageTabTxt.setTextColor(inactiveTabColor)
                binding.invitationTabTxt.setTextColor(activeTabColor)
                binding.notificationTabTxt.setTextColor(inactiveTabColor)

                addFragment(InvitationTabFragment(), false)
            }
            binding.notificationsTab -> {
                binding.messagesTabDivider.visibility = View.INVISIBLE
                binding.invitationTabDivider.visibility = View.INVISIBLE
                binding.notificationsTabDivider.visibility = View.VISIBLE

                binding.messageTabTxt.setTextColor(inactiveTabColor)
                binding.invitationTabTxt.setTextColor(inactiveTabColor)
                binding.notificationTabTxt.setTextColor(activeTabColor)

                addFragment(NotificationsTabFragment(), false)
            }
            binding.chartIcon -> {
                (activity as TabBarActivity).let { it.addFragment(EventFragment(), false) }
            }
        }
    }

    public fun addFragment(frag: Fragment, addToBackStack: Boolean) {

        val trans = childFragmentManager.beginTransaction()

        if (addToBackStack) {
            trans.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_right, R.anim.slide_in_from_right, R.anim.slide_out_to_right)
            trans.add(R.id.messageMainContainer, frag)
        } else {
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            trans.replace(R.id.messageMainContainer, frag)
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
        return childFragmentManager.findFragmentById(R.id.messageMainContainer)
    }
}