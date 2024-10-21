package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.ContactUsFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.ContactUsFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactUsFragment : BaseDataBindingFragment<ContactUsFragmentDataBinding>
    (R.layout.fragment_contact_us),
    ContactUsFragmentCallback {
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

        initListeners()
    }

    private fun initListeners() {
        binding.llTopView.setOnClickListener {

        }
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
/*
Screen :: MenuContactView
opens on click :: --- MenuView - Contactez-nous

nav title: Contactez-nous

Support Client
----(style: .Medium, ofSize: 15


Link("**Envoyez-nous un e-mail**", destination: URL(string: "mailto:contact@club-in.com")!)

Posez votre question ou donnez nous vos recommendations, nous vous répondrons en 1 jours ouvrés.
----style: .Medium, ofSize: 12) secondary color

Link("**Appelez-nous**", destination: URL(string: "tel:0644163540")!)

Seulement en cas d'**urgence*, de signalement de *malfonction dans l'app* ou de *réclamation lié au paiement**
----style: .Medium, ofSize: 12) secondary color*/
