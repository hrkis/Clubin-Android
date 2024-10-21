package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.CardBanFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.CardBanFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CardBanFragment : BaseDataBindingFragment<CardBanFragmentDataBinding>
    (R.layout.fragment_card_ban),
    CardBanFragmentCallback {
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

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.buttonSubmit.setOnClickListener {
            binding.buttonSubmit.text = "Sauvegarder"
            binding.editTextTextPays.isEnabled = true
            binding.editTextTextName.isEnabled = true
            binding.editTextTextCountry.isEnabled = true
            binding.editTextTextCard.isEnabled = true
            binding.editTextTextBIC.isEnabled = true

        }
    }

/*    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_card_ban, container, false)

        val button: Button = view.findViewById<View>(R.id.buttonSubmit) as Button

        val pays: EditText = view.findViewById<View>(R.id.editTextTextPays) as EditText
        val name: EditText = view.findViewById<View>(R.id.editTextTextName) as EditText
        val country: EditText = view.findViewById<View>(R.id.editTextTextCountry) as EditText
        val card: EditText = view.findViewById<View>(R.id.editTextTextCard) as EditText
        val bic: EditText = view.findViewById<View>(R.id.editTextTextBIC) as EditText

        button.setOnClickListener {
            button.setText("Sauvegarder");
            pays.isEnabled = true
            name.isEnabled = true
            country.isEnabled = true
            card.isEnabled = true
            bic.isEnabled = true

        }

        return view;
    }*/
}

/*
Screen :
MenuRIBView
opens on click :: opens on click :: --- MenuView - Paiement - Préférences de paiement / RIB. --- Compte bancaire (par défaut)

nav title: Mon RIB

-----
RowTwoLineTextField: {
    Text(title)
        .bold()
        .body()
    TextField(content, text: $name)
    .frame(height: height, alignment: .topLeading)
    .font(.headline)
    .foregroundColor(.secondary)
}
--------
if isEditing {
    RowTwoLineTextField(title: "Pays de domiciliation bancaire", content: "Pays")
    RowTwoLineTextField(title: "Titulaire du compte", content: "Nom et prénoms")
    RowTwoLineTextField(title: "Nom de l'agence", content: "ex: Banque de France")
    RowTwoLineTextField(title: "IBAN", content: "ex: FR7630001007941234567890185")
    RowTwoLineTextField(title: "BIC (ou SWIFT)", content: "ex: CMCIFRPP")

} else {
    RowTwoLineField(title: "Pays de domiciliation bancaire", content: rib.country)
    RowTwoLineField(title: "Titulaire du compte", content: rib.owner)
    RowTwoLineField(title: "Nom de l'agence", content: rib.agencyName)
    RowTwoLineField(title: "IBAN", content: rib.iban)
    RowTwoLineField(title: "BIC (ou SWIFT)", content: rib.bic)

}

isEditing ? "Sauvegarder" : "Modifier les informations")
.body() - blue default color


----- model and dummy data --
struct Rib : Identifiable {
    var id = UUID()
    var country: String
    var owner: String
    var agencyName: String
    var iban: String
    var bic: String
}

let ribData = Rib(country: "France", owner: "Valjean Jean", agencyName: "Banque de France", iban: "FR7630001007941234567890185", bic: "CMCIFRPP")*/
