package com.clubin.com.ui.fragment.hosts.view

import android.content.Context
import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.HostCreationTagSelectionFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.ui.tabbar.TabBarActivity

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HostCreationTagSelectionFragment : BaseDataBindingFragment<HostCreationTagSelectionFragmentDataBinding>
    (R.layout.fragment_host_creation_tag_selection),
    AccountEditFragmentCallback {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }
    override fun injectDaggerComponent() {

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HostCreationTagSelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {

        binding.continueBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.addFragment(HostCreationRulesDurationFragment(), true)
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
Screen: HostCreationDescriptionView

title:: Décrivez votre évènement
--style: .Bold, ofSize: 22


Textfield::
title: "Nom", content: "\"Soirée DJ - Cocktails\""
---- 16 bold

Textfield:
title: "Description", content: "\"Evènement privé avec un zefnjkgkznbkebfjbzkfjbkjzbkjbkjzbfkbfkefzbkjbkzbjkfbkzbfzkfbkjbfzezebfjkfbzfbze\"", height: 20)


*Selectionnez vos Tags* (min: 1 - max: 5)
----style: .Medium, ofSize: 16


Quels tags correspondent le mieux au(x) thème(s) de votre Event ?
----.Medium, ofSize: 12


// TAG 1
tagNight

Clubin Night
-----bold , 12
----background(vm.filter.themes[0].gradiantColor2.opacity(0.5))
.cornerRadius(6)

ces thèmes sont accèes sur la soirée ect blabbla
---- semibold, 12

TagView(tags: vm.tagsNight)


// TAG 2
tagVibes

Clubin Vibes
-----bold , 12
----background(vm.filter.themes[1].gradiantColor2.opacity(0.5))
.cornerRadius(6)

ces thèmes sont accèes sur la soirée ect blabbla
---- semibold, 12

TagView(tags: vm.tagsVibes)



// TAG 3
tagDiscovery


Clubin Discovery
-----bold , 12
----background(vm.filter.themes[1].gradiantColor2.opacity(0.5))
.cornerRadius(6)

ces thèmes sont accèes sur la soirée ect blabbla
---- semibold, 12


TagView(tags: vm.tagsAtelier)

Button:: Continuer
on click :: HostCreationRulesDurationView  (Règlement intérieur)*/
