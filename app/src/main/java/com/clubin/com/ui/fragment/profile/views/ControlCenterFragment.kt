package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.ControlCenterFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.ControlCenterFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ControlCenterFragment : BaseDataBindingFragment<ControlCenterFragmentDataBinding>
    (R.layout.fragment_control_center),
    ControlCenterFragmentCallback {
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

    }
}

/*
Screen :
MenuControlCenterView

opens on click :: --- MenuView - Centre de contrôle

nav title: Centre de contrôle

view 1::
Ressources et Conseils
---- style: .Bold, ofSize: 22)

Gestes de premiers secours
-----backgroundColor: .red, width: 140, height: 140, fontSize: 20, font: .Bold

Vol - Casse ?
----foregroundColor: .white, backgroundColor: .purple, width: 140, height: 140, fontSize: 20, font: .Bold)
Que faire en cas de Vol ou Casse ?
------(style: .Medium, ofSize: 12)

Incendie
---- foregroundColor: .white, backgroundColor: .orange, width: 140, height: 140, fontSize: 20, font: .Bold)
Les mesures à suivre
------(style: .Medium, ofSize: 12)

Litiges / Violence
---- foregroundColor: .white, backgroundColor: .blue, width: 140, height: 140, fontSize: 20, font: .Bold)
Que faire en cas de problème avec une/des personnes dans la soirée ?
------(style: .Medium, ofSize: 12)



view 2:

Centre de sécurité
---- style: .Bold, ofSize: 22

La Sécurité selon Clubin

Obtenez l’assistance, les outils et les informations dont vous avez besoin.*/
