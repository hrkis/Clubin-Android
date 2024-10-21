package com.clubin.com.ui.fragment.hosts.view

import android.content.Context
import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.HostCreationPlaceTypeFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.ui.tabbar.TabBarActivity

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HostCreationPlaceTypeFragment : BaseDataBindingFragment<HostCreationPlaceTypeFragmentDataBinding>
    (R.layout.fragment_host_creation_place_type),
    AccountEditFragmentCallback {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }
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
            HostCreationPlaceTypeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        binding.continueBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.addFragment(HostCreationTagSelectionFragment(), true)
            }
        }
        binding.backBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.removeFragment()
            }
        }
        binding.closeBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.removeFragment()
            }
        }

    }
}

/*
From Screen: HostCreationAdresseView

continue click :: HostCreationPlaceTypeView screen ( Définissez le type de lieu)


Screen ::: HostCreationPlaceTypeView screen

title: Définissez le type de lieu
--style: .Bold, ofSize: 22

Button(action: {houseIsSelected.toggle()}) {
    ButtonEmptyComponent(text: "Appartement")
}

------ bold 17 , lineWidth: 1.4 , white

Button(action: {houseIsSelected.toggle()}) {
    ButtonEmptyComponent(text: "Maison")
}
Button(action: {houseIsSelected.toggle()}) {
    ButtonEmptyComponent(text: "Villa")
}
Button(action: {houseIsSelected.toggle()}) {
    ButtonEmptyComponent(text: "Lieu d'exception")
}

textfield::
title: "Autres", content: "Précisez"
---- 16 bold

ButtonDoubleComponent(leftText: "Continuer", rightImage: "arrow.right")
.padding()
}
---on click: HostCreationDescriptionView screen (Décrivez votre évènement)*/
