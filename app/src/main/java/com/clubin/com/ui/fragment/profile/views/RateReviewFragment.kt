package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.RateReviewFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.PreferencesFragmentCallback


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RateReviewFragment : BaseDataBindingFragment<RateReviewFragmentDataBinding>
    (R.layout.fragment_rate_review),
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

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RateReviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }
}

/*
Screen :: MenuRatingAppView (Donner votre avis)

Navigation title: Donner votre avis
nav button: Envoyer

stars: 5
----- image name ::    star.fill and star

Toucher des étoiles pour noter
----size: 10, weight: .regular
-- seconday color - 3C3C43 opacity 60%

Laisser nous un commentaire (facultatif)
(style: .Medium, ofSize: 16), secondary color

Titre
Commentaire
(style: .SemiBold, ofSize: 18)*/
