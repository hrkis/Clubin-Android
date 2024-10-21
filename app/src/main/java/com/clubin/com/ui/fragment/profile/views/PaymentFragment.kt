package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.PaymentFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.PaymentFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PaymentFragment : BaseDataBindingFragment<PaymentFragmentDataBinding>
    (R.layout.fragment_payment),
    PaymentFragmentCallback {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun injectDaggerComponent() {

    }

    override fun onDataBindingCreated() {
        binding.callback = this
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.llVirements.setOnClickListener {
            fragmentChange(VirementsFragment())
        }
        binding.llPrFRences.setOnClickListener {
            fragmentChange(PreferencesFragment())
        }
        binding.llHistorique.setOnClickListener {
            fragmentChange(PaymentHistoryFragment())
        }
    }


}

/*
Screen:: MenuPaymentView
opens on click :: --- MenuView - Paiement

nav title: Paiement

row 1:
name: "Virements", chevron: "chevron.right"
---- style: .SemiBold, ofSize: 17
on click :: Virements

row 2:
Historique des paiements
---- style: .SemiBold, ofSize: 17
on click :: Paiements

row 3:
Préférences de paiement / RIB
---- style: .SemiBold, ofSize: 17
on click :: Préférences*/
