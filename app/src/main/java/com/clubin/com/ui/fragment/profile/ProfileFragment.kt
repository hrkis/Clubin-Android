package com.clubin.com.ui.fragment.profile

import android.content.Context
import android.content.Intent
import com.clubin.com.R
import com.clubin.com.databinding.ProfileFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.ContactUsFragmentCallback
import com.clubin.com.ui.fragment.profile.views.*

class ProfileFragment : BaseDataBindingFragment<ProfileFragmentDataBinding>
    (R.layout.fragment_profile),
    ContactUsFragmentCallback {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onDataBindingCreated() {

        binding.llContactez.setOnClickListener {
            fragmentChange(ContactUsFragment())
        }

        binding.llProfile.setOnClickListener {
            var intent = Intent(requireActivity().applicationContext, AccountEditActivity::class.java)
            startActivity(intent)
        }
        binding.llNotification.setOnClickListener {
            fragmentChange(NotificationFragment())
        }
        binding.llLock.setOnClickListener {
            fragmentChange(SecurityFragment())
        }
        binding.llPayment.setOnClickListener {
            fragmentChange(PaymentFragment())
        }
        binding.llCenter.setOnClickListener {
            fragmentChange(ControlCenterFragment())
        }
        binding.llNoter.setOnClickListener {
            fragmentChange(RateReviewFragment())
        }
    }

    override fun injectDaggerComponent() {

    }
}


