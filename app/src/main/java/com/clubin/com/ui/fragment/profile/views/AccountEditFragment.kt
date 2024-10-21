package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import android.view.View
import com.clubin.com.R
import com.clubin.com.databinding.AccountEditFragmentOnlyDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AccountEditFragment : BaseDataBindingFragment<AccountEditFragmentOnlyDataBinding>
    (R.layout.fragment_account_edit), AccountEditFragmentCallback {
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
        showHideViews(false)
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.textViewEdit.setOnClickListener {
            showHideViews(true)
        }
        binding.rlEmail.setOnClickListener {
            fragmentChange(EmailChangeFragment())
        }
        binding.rlTelephone.setOnClickListener {
            fragmentChange(TelePhoneEditFragment())
        }
    }

    private fun showHideViews(isEdit: Boolean) {

        if (!isEdit) {
            binding.ivEdit.visibility = View.GONE
            binding.textViewEmail.setTextColor(resources.getColor(R.color.white))
            binding.textViewEmailValue.setTextColor(resources.getColor(R.color.white))
            binding.textViewTelephone.setTextColor(resources.getColor(R.color.white))
            binding.textViewTelephoneValue.setTextColor(resources.getColor(R.color.white))

            binding.textViewEdit.text = "Modifier les informations"
            binding.textViewFirstNameValue.visibility = View.VISIBLE
            binding.editTextFirstName.visibility = View.GONE

            binding.textViewLastNameValue.visibility = View.VISIBLE
            binding.editTextLastName.visibility = View.GONE

            binding.textViewAgeValue.visibility = View.VISIBLE
            binding.editTextAge.visibility = View.GONE

            binding.textViewBioValue.visibility = View.VISIBLE
            binding.editTextBio.visibility = View.GONE

            binding.textViewInstaValue.visibility = View.VISIBLE
            binding.editTextInsta.visibility = View.GONE

            binding.textViewFacebookValue.visibility = View.VISIBLE
            binding.editTextFacebook.visibility = View.GONE

            binding.textViewSexValue.visibility = View.VISIBLE
            binding.editTextSex.visibility = View.GONE
        } else {
            binding.ivEdit.visibility = View.VISIBLE
            binding.textViewEmail.setTextColor(resources.getColor(R.color.green))
            binding.textViewEmailValue.setTextColor(resources.getColor(R.color.green))
            binding.textViewTelephone.setTextColor(resources.getColor(R.color.green))
            binding.textViewTelephoneValue.setTextColor(resources.getColor(R.color.green))

            binding.textViewEdit.text = "Sauvegarder les informations"
            binding.textViewFirstNameValue.visibility = View.GONE
            binding.editTextFirstName.visibility = View.VISIBLE

            binding.textViewLastNameValue.visibility = View.GONE
            binding.editTextLastName.visibility = View.VISIBLE

            binding.textViewAgeValue.visibility = View.GONE
            binding.editTextAge.visibility = View.VISIBLE

            binding.textViewBioValue.visibility = View.GONE
            binding.editTextBio.visibility = View.VISIBLE

            binding.textViewInstaValue.visibility = View.GONE
            binding.editTextInsta.visibility = View.VISIBLE

            binding.textViewFacebookValue.visibility = View.GONE
            binding.editTextFacebook.visibility = View.VISIBLE

            binding.textViewSexValue.visibility = View.GONE
            binding.editTextSex.visibility = View.VISIBLE
        }
    }

}
/*
Screen :
AccountEditView

opens on click :: --- MenuView - on click of username and profile photo - Modifier mon profil

(image: "Alex", size: 120)

if isEditing {
    Button {changePicture.toggle()} label: {
        Image(systemName: "pencil.circle.fill")
        .font(.title)
        .foregroundColor(.blue)
    }
            .buttonStyle(.plain)
    .offset(x: 50, y: 40)
}
}

Button(action: {isEditing.toggle()}, label: {
    Text(isEditing ? "Sauvegarder les informations" : "Modifier les informations")
    .body()
        .foregroundColor(.blue)
    .padding(10)
})

if isEditing {
    editingView
} else {

    fixedView

}




********editingView ::

Général
-----bold 16


title --- style: .Medium, ofSize: 12)
centertext --style: .Medium, ofSize: 12

CenterRowTextFieldView(textInput: "", title: "Nom d'utilisateur",
centertext: "@alex_b")

CenterRowTextFieldView(textInput: "", title: "Nom et prénom",
centertext: "Alexandre Baysset")
CenterRowTextFieldView(textInput: "", title: "Age",
centertext: "22")
CenterRowTextFieldView(textInput: "", title: "Bio",
centertext: "Digital goodies designer @pixsellz Everything is designed.")


Réseaux
--- bold 16
CenterRowTextFieldView(textInput: "", title: "Instagram",
centertext: "instagram.com/brandon_f")
CenterRowTextFieldView(textInput: "NIoput", title: "Facebook",
centertext: "facebook.com/BrandonFang")


Informations privés - contact
----- bold 16

E-mail
mailto:jacob.west@gmail.com
-----on click - open AccountVerificationEmailView

Téléphone
+1 202 555 0147
-----on click - open AccountVerificationSMSView

Sexe
Homme


******** fixedView::

Général
CenterRowTextView(title: "Nom d'utilisateur",
centertext: "@alex_b")
CenterRowTextView(title: "Nom et prénom",
centertext: "Alexandre Baysset")
CenterRowTextView(title: "Age",
centertext: "22")
CenterRowTextView(title: "Bio",
centertext: "Digital goodies designer @pixsellz Everything is designed.")

Réseaux
CenterRowTextView(title: "Instagram",
centertext: "instagram.com/brandon_f")
CenterRowTextView(title: "Facebook",
centertext: "facebook.com/BrandonFang")

Informations privés - contact
CenterRowTextView(title: "E-mail",
centertext: "mailto:jacob.west@gmail.com")

CenterRowTextView(title: "Téléphone",
centertext: "+1 202 555 0147")

CenterRowTextView(title: "Sexe",
centertext: "Homme")*/
