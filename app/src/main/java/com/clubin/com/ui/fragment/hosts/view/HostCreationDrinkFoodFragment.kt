package com.clubin.com.ui.fragment.hosts.view

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.clubin.com.R
import com.clubin.com.databinding.HostCreationDrinkFoodFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.ui.tabbar.TabBarActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HostCreationDrinkFoodFragment : BaseDataBindingFragment<HostCreationDrinkFoodFragmentDataBinding>
    (R.layout.fragment_host_creation_drink_food),
    AccountEditFragmentCallback {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    var alcoolDisable = false
    var NouritureDisable = false

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
            HostCreationDrinkFoodFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {

        binding.continueBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.addFragment(HostCreationPriceFragment(), true)
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

        binding.tvBoissonsOui.setOnClickListener {

            if (alcoolDisable) {
                alcoolDisable = false
                binding.tvBoissonsOui.text = "Oui"
                binding.tvBoissonsOui.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvAlcool.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvBoiAutorise.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvBoiAutorise.text = "Autorisé "

                binding.tvAmener.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvAmenerAutoris.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvAmenerAutoris.text = "Autorisé "
                binding.tvCareer.setTextColor(ContextCompat.getColor(mContext, R.color.white))

                binding.ivBio1.setColorFilter(ContextCompat.getColor(mContext, R.color.green))
                binding.ivBio2.setColorFilter(ContextCompat.getColor(mContext, R.color.green))
                binding.tvBoissonsOui.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
                binding.rlBoi1.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
                binding.rlBoi2.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
            } else {
                alcoolDisable = true
                binding.tvBoissonsOui.text = "Non"
                binding.tvBoissonsOui.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                binding.tvAlcool.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvAmener.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvCareer.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvAmenerAutoris.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvBoiAutorise.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvBoiAutorise.text = "Interdit "
                binding.tvAmenerAutoris.text = "Interdit "

                binding.ivBio1.setColorFilter(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.ivBio2.setColorFilter(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvBoissonsOui.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_red)
                binding.rlBoi1.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_background)
                binding.rlBoi2.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_background)


            }
        }

        var isAlcool = false
        binding.rlBoi1.setOnClickListener {
            if (!alcoolDisable) {
                if (isAlcool) {
                    isAlcool = false
                    binding.tvAlcool.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                    binding.tvBoiAutorise.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                    binding.rlBoi1.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
                    binding.ivBio1.setColorFilter(ContextCompat.getColor(mContext, R.color.green))
                    binding.tvBoiAutorise.text = "Autorisé "
                } else {
                    isAlcool = true
                    binding.rlBoi1.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_red)
                    binding.tvAlcool.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.tvBoiAutorise.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.ivBio1.setColorFilter(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.tvBoiAutorise.text = "Interdit "
                }
            }
        }
        var isAmeerBoi = false
        binding.rlBoi2.setOnClickListener {
            if (!alcoolDisable) {
                if (isAmeerBoi) {
                    isAmeerBoi = false
                    binding.tvAmenerAutoris.text = "Autorisé "
                    binding.tvAmener.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                    binding.tvAmenerAutoris.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                    binding.rlBoi2.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
                    binding.ivBio2.setColorFilter(ContextCompat.getColor(mContext, R.color.green))
                } else {
                    isAmeerBoi = true
                    binding.tvAmenerAutoris.text = "Interdit "
                    binding.ivBio2.setColorFilter(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.tvAmenerAutoris.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.tvAmener.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                    binding.rlBoi2.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_red)

                }
            }
        }
        binding.rlBoi3.setOnClickListener {
            bottomSheetShow()
        }

        binding.tvNourritureOui.setOnClickListener {
            if (NouritureDisable) {
                NouritureDisable = false
                binding.tvNourritureOui.text = "Oui"
                binding.tvNourritureOui.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvNourritureAmener.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvNourritureAmenerAutoris.setTextColor(ContextCompat.getColor(mContext, R.color.green))
                binding.tvNourritureAmenerAutoris.text = "Autorisé "
                binding.tvCareer2.setTextColor(ContextCompat.getColor(mContext, R.color.white))
                binding.ivNour1.setColorFilter(ContextCompat.getColor(mContext, R.color.green))

                binding.tvNourritureOui.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
                binding.rlNour1.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_green)
                binding.rlNour2.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_background)
            } else {
                NouritureDisable = true
                binding.tvNourritureOui.text = "Non";
                binding.tvNourritureAmenerAutoris.text = "Interdit "
                binding.tvNourritureOui.setTextColor(ContextCompat.getColor(mContext, R.color.dark_red))
                binding.tvNourritureAmener.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvNourritureAmenerAutoris.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvCareer2.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))

                binding.ivNour1.setColorFilter(ContextCompat.getColor(mContext, R.color.text_light_white))
                binding.tvNourritureOui.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_red)
                binding.rlNour1.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_background)
                binding.rlNour2.background = ContextCompat.getDrawable(mContext, R.drawable.transparent_background)
            }
        }
    }

    private fun bottomSheetShow() {
        val dialog = BottomSheetDialog(requireActivity())
        val view = layoutInflater.inflate(R.layout.layout_bottom_sheet2, null)

        val btnAnnuler = view.findViewById<Button>(R.id.btnAnnuler)
        btnAnnuler.setOnClickListener {
            dialog.dismiss()
        }
        val btnValider = view.findViewById<Button>(R.id.btnValider)
        btnValider.setOnClickListener {
            dialog.dismiss()
        }
        val seekBar = view.findViewById<SeekBar>(R.id.seekBar)
        seekBar.progress = 10
        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }
}
/*

Screen :: DrinkBudgetView

title: Définir un budget boisson
---(style: .ExtraBold, ofSize: 28))

Slider(value: $alcoolPrice, in: 2...20)
                    .foregroundColor(Color("clubincolor")). --- 2CD0A8
                    .frame(width: 350)

"\(alcoolPrice.rounded().clean)€ / personne"
----bold, 22

"- Ce prix sera ajouté au prix total du billet de chaque participants."
------------bold, 12 opacity(0.8)

"- Veuillez faire en sorte que ce prix reflète réellement celui des achats que vous ferez."


"Quels genre de boissons ?"
----bold, 22

TagView(tags: alcoolType)
a0lcoolType = [
        EventTagItem(title: "Bière", isSelected: false),
  0      EventTagItem(title: "Vin", isSelected: false),
   0     EventTagItem(title: "Rhum", isSelected: false),
    0    EventTagItem(title: "Whisky", isSelected: false),
     0   EventTagItem(title: "Gin", isSelected: false),
      0  EventTagItem(title: "Vodka", isSelected: false),
       0 EventTagItem(title: "Cocktails", isSelected: false),
        0EventTagItem(title: "Punch", isSelected: false),
        E0ventTagItem(title: "Mojito", isSelected: false),
        Ev0entTagItem(title: "Champagne", isSelected: false)
    ]0
0

0TextField(title: "Autres", content: "Précisez")
0
B0ottom button :
An0nuler
---0--style: .ExtraBold, ofSize: 19, red
0
V0alider
--0--style: .ExtraBold, ofSize: 19))
    0                    .tint(.blue
     0                   ....................
0
0
S0creen :: HostCreationDrinkFoodView

title:: Que y'aura t'il à votre évènement ?
-----style: .ExtraBold, ofSize: 28

En cochant \"Non\", vous empechez toute présence de l'élément en question.
---style: .Medium, ofSize: 12

Boissons
style: .ExtraBold, ofSize: 28

ButtonEmptyComponent(text: noDrink ? "Non" : "Oui", foregroundColor: noDrink ?
 .red : Color.theme.accent,
----accent - 2CD0A8, 17 bold

alcoolPolicy::
text: "Alcool",  --- bold, 16
rightText: isForbiddenAlcool ? "Interdit" : "Autorisé", ------16 medium
image: arrow.2.squarepath

Nous vous rappelons que toute consommation de boisson alcoolisé est strictement prohibé par la loi pour les personnes de moins de 18 ans et implique la responsabilité du consommateur.
---style: .Regular, ofSize: 10 , scondary color

bringDrinkPolicy::
ButtonToggleSwitchComponent(text: "Amener sa boisson",
rightText: isNotBringingDrinks ? "Interdit" : "Autorisé",
accentColor: isNotBringingDrinks ? Color.special.lipstick D54667 : Color.theme.accent 2CD0A8 ,

createBudgetDrinks::
ButtonToggleSwitchComponent(text: isValidatedDrinkBudget ? "Cagnotte créé":"Créer une cagnotte", rightText: "", image:isValidatedDrinkBudget ? "checkmark": "chart.pie.fill", accentColor: isValidatedDrinkBudget ? Color.theme.blue : .white)

Créer une cagnotte signifie blabla lnaoianoeinf description a faire par alex.

Nourriture
style: .ExtraBold, ofSize: 28

ButtonEmptyComponent(text: noDrink ? "Non" : "Oui", foregroundColor: noDrink ? .red : Color.theme.accent,
----accent - 2CD0A8, 17 bold

bringFoodPolicy::
ButtonToggleSwitchComponent(text: "Amener à manger",
rightText: isNotBringingFood ? "Interdit" : "Autorisé",
accentColor: isNotBringingFood ? Color.special.lipstick : Color.theme.accent,

createBudgetFood::
ButtonToggleSwitchComponent(text: isValidatedFoodBudget ? "Cagnotte créé":"Créer une cagnotte", rightText: "", image:isValidatedFoodBudget ? "checkmark": "chart.pie.fill", accentColor: isValidatedFoodBudget ? Color.theme.blue : .white)

Créer une cagnotte signifie blabla lnaoianoeinf description a faire par alex
--.Regular, ofSize: 10

Continuer::
on click:: HostCreationPriceView
 */
