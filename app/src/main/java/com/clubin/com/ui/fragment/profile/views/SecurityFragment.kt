package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.SecurityFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.SecurityFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecurityFragment : BaseDataBindingFragment<SecurityFragmentDataBinding>
    (R.layout.fragment_security),
    SecurityFragmentCallback {
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
        binding.llChangePassword.setOnClickListener {
            fragmentChange(PasswordChangeFragment())
        }
        binding.llConfidential.setOnClickListener {
            fragmentChange(ConfidentialFragment())
        }
    }

}

/*
Screen :
MenuPrivacyView
opens on click :: --- MenuView - Données et Sécurité

nav title: Données et Sécurité

Row 1:
(image: "lock", name: "Confidentialité", chevron: "chevron.right",
---- .SemiBold, ofSize: 17)
----on click:: Confidentialité

Row 2:
image: "key", name: "Changer de mot de passe", chevron: "chevron.right"
---- .SemiBold, ofSize: 17)
----on click:: MenuPasswordChangeView


RoundedRectangle(cornerRadius: 15)
.stroke(Color.red, lineWidth: 3)

Supprimer mon compte
---   .semibold()
.body() -- (style: .Medium, ofSize: 16)
.foregroundColor(.red)

En faisant cela, Clubin supprimera définitivement toutes informations vous concernant.
- (style: .Medium, ofSize: 12) seconday color
*/

