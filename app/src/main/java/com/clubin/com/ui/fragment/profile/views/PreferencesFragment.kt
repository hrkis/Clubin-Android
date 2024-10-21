package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.PreferencesFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.PreferencesFragmentCallback


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PreferencesFragment : BaseDataBindingFragment<PreferencesFragmentDataBinding>
    (R.layout.fragment_preferences),
    PreferencesFragmentCallback {
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
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.llComplete.setOnClickListener {
            fragmentChange(CardBanFragment())
        }
    }
}

/*
Screen :: Préférences (MenuTransferPreferencesView)
opens on click :: --- MenuView - Paiement - Préférences de paiement / RIB


nav title: Paiements

view 1: Sur quel compte souhaitez-vous recevoir l'argent disponible ?")
.footnote()

Row 1:
image: "building.columns", name: "Compte bancaire (par défaut)", chevron: "chevron.right"
on click:: Mon RIB screen

Row 2:
image: "p.circle", name: "Paypal (arrive bientôt)", chevron: "chevron.right")
on click:: ( nothing yet )*/
