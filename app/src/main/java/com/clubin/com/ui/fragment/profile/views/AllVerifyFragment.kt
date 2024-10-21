package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.AllVerifyFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.ContactUsFragmentCallback


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AllVerifyFragment : BaseDataBindingFragment<AllVerifyFragmentDataBinding>
    (R.layout.fragment_allverify),
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


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AllVerifyFragment().apply {
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
        binding.llEmail.setOnClickListener {
            fragmentChange(EmailChangeFragment())
        }
        binding.llTelephone.setOnClickListener {
            fragmentChange(TelePhoneEditFragment())
        }
        binding.llInfo.setOnClickListener { }
        binding.llDeclare.setOnClickListener { }

    }
}

/*Screen: AccountRemainingTasksView
title: Tâches restantes

Ajoutez les *informations importantes* relatives à votre compte pour établir une relation de confiance avec la communauté Clubin.
--------style: .Medium, ofSize: 12

1. image: "phone", text: "Vérifier votre téléphone",
 foregroundColor: Color.black, backgroundColor: Color.white,
 width: 120, height: 110, font: .SemiBold
-----onclick : AccountVerificationSMSView
----fontSize: CGFloat = 16
2. image: "paperplane", text: "Vérifier votre Email",  foregroundColor: Color.black, backgroundColor: Color.white, width: 120, height: 110, font: .SemiBold
-----onclick : AccountVerificationEmailView
3. image: "text.badge.checkmark", text: "Vérifier vos infos",  foregroundColor: Color.black, backgroundColor: Color.white, width: 120, height: 110, font: .SemiBold
4. image: "checkmark.shield", text: "Vérification d'identité",  foregroundColor: Color.black, backgroundColor: Color.white, width: 120, height: 110, font: .SemiBold

 */