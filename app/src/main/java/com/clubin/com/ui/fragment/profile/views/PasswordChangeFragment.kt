package com.clubin.com.ui.fragment.profile.views

import android.content.Intent
import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.ui.auth.passwordreset.view.PasswordResetCodeActivity
import com.clubin.com.databinding.PasswordChangeFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.PasswordChangeFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PasswordChangeFragment :  BaseDataBindingFragment<PasswordChangeFragmentDataBinding>
    (R.layout.fragment_password_change), PasswordChangeFragmentCallback {
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

        binding.llEmail.setOnClickListener {
            var intent = Intent(requireActivity(), PasswordResetCodeActivity::class.java)
            startActivity(intent)
        }

    }


}

/*
Screen :
MenuPasswordChangeView
opens on click :: --- MenuView - Données et Sécurité --  Changer de mot de passe



image: "Paris", size: 90)

Ugo Lafosse
--- (style: .ExtraBold, ofSize: 28)

Envoyer le code par e-mail
----- style: .Medium, ofSize: 16)

user email
----style: .Medium, ofSize: 12)

on click
present :PasswordResetCodeView*/
