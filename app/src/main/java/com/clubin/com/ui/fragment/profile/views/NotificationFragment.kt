package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.NotificationFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.NotificationFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NotificationFragment :  BaseDataBindingFragment<NotificationFragmentDataBinding>
    (R.layout.fragment_notification), NotificationFragmentCallback {
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
            NotificationFragment().apply {
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

    }
}
/*
Screen :
MenuNotificationsView

opens on click :: --- MenuView - Notifications

nav title: Notifications

view 1::
"In-App", LabelImage: "bell.badge"
------(style: .Medium, ofSize: 15)

Pour activer/désactiver l'affichage des notifications In-App, rendez-vous dans Réglages > Clubin > Notifications.
-----(style: .Medium, ofSize: 12), accent color

Réservation / Annulation
---(style: .Bold, ofSize: 14)

Vous informe quand quelqu'un réserve votre évènement, ou en cas d'annulation vous concernant.
----(style: .Medium, ofSize: 12)

Paiement
Vous informe de vos réceptions de paiement.


View 2:

labelText: "E-mail", LabelImage: "envelope.badge"

Places
Vous envoie votre réservation par e-mail.

Factures
Vous transmets par e-mail un compte rendu de vos factures.

Clubin
Recevez les dernières exclusivités Clubin (2 offres par mois). Vous pouvez vous désabonnez à tout moment directement depuis le mail de notre Newsletter.

View 3:

labelText: "SMS", LabelImage: "message")

Ce sont des informations importantes qui vous seront directement envoyés par SMS.
---accent,   (style: .Medium, ofSize: 12)

Réservations
Confirmation de réservation avec rappel des informations clés.

Important / Annulation
Informations importantes, par exemple l'annulation d'un évènement.*/

