package com.clubin.com.ui.fragment.hosts.view

import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.recyclerview.widget.GridLayoutManager
import com.clubin.com.R
import com.clubin.com.databinding.HostCreationRulesDurationFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.hosts.adapter.HostCreationRuleAdapter
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.ui.tabbar.TabBarActivity
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HostCreationRulesDurationFragment : BaseDataBindingFragment<HostCreationRulesDurationFragmentDataBinding>
    (R.layout.fragment_host_creation_rules_duration),
    AccountEditFragmentCallback {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    val list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list.add("Interdit aux animaux");
        list.add("Interdit aux animaux");
        list.add("Masque obligatoire");
        list.add("Pass sanitaire obligatoire");
        list.add("Autre Idée ?");

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
            HostCreationRulesDurationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        addAdapter();
        binding.continueBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.addFragment(HostCreationDrinkFoodFragment(), true)
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
        binding.tvStartingTime.setOnClickListener {
            showTimePicker(1)
        }
        binding.tvEndingTime.setOnClickListener {
            showTimePicker(2)
        }

    }

    private fun showTimePicker(type: Int) {
        val mTimePicker: TimePickerDialog
        val mCurrentTime = Calendar.getInstance()
        val hour = mCurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mCurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(requireActivity(), object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

                val formattedTime: String = when {
                    hourOfDay == 0 -> {
                        if (minute < 10) {
                            "${hourOfDay + 12}:0${minute} AM"
                        } else {
                            "${hourOfDay + 12}:${minute} AM"
                        }
                    }
                    hourOfDay > 12 -> {
                        if (minute < 10) {
                            "${hourOfDay - 12}:0${minute} PM"
                        } else {
                            "${hourOfDay - 12}:${minute} PM"
                        }
                    }
                    hourOfDay == 12 -> {
                        if (minute < 10) {
                            "${hourOfDay}:0${minute} PM"
                        } else {
                            "${hourOfDay}:${minute} PM"
                        }
                    }
                    else -> {
                        if (minute < 10) {
                            "${hourOfDay}:${minute} AM"
                        } else {
                            "${hourOfDay}:${minute} AM"
                        }
                    }
                }

                if (type == 1) {
                    binding.tvStartingTime.text = formattedTime

                } else {
                    binding.tvEndingTime.text = formattedTime
                }
            }
        }, hour, minute, false)
        mTimePicker.show()
    }

    fun addAdapter() {
        val adapter = HostCreationRuleAdapter(mContext, list, object : HostCreationRuleAdapter.ItemClickListener {
            override fun onItemClickListener(pos: Int) {
                (activity as TabBarActivity)?.let {
                    // it.addFragment(HostCreationPlaceTypeFragment(), true)
                }
            }

        })
        var layoutManager = GridLayoutManager(mContext, 2)

        binding.ruleRecycler.layoutManager = layoutManager
        binding.ruleRecycler.adapter = adapter
    }
}
/*

Screen : HostCreationRulesDurationView

title:
Règlement intérieur
---style: .ExtraBold, ofSize: 28


Heure de début :"
---style: .Bold, ofSize: 22
datepicker - save startHour

Heure de fin :
---style: .Bold, ofSize: 22
datepicker - save $endHour


Définir vos règles de maison
-----bold, 22

text - --houseRules
.padding(5)
.font(.type(style: .SemiBold, ofSize: 14))
.foregroundColor(.white)
.frame(minWidth: 0, maxWidth: .infinity, minHeight: 50)
.background(Color.special.peacock) -- 29889A
---cornerradius 12
--houseRules = ["Interdit aux animaux", "Interdit de fumer", "Masque obligatoire",
 "Pass sanitaire obligatoire", "Autre Idée ?"]


Texfield:
"Autres", content: "Créer une règle"

Button:
Continuer
--- on click:: HostCreationDrinkFoodView (Que y'aura t'il à votre évènement ?)*/
