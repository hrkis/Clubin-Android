package com.clubin.com.ui.fragment.hosts.view

import android.content.Context
import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.ui.tabbar.TabBarActivity

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HostCreationPriceFragment : BaseDataBindingFragment<com.clubin.com.databinding.HostCreationPriceFragmentDataBinding>
    (R.layout.fragment_host_creation_price),
    AccountEditFragmentCallback {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    private var count: Int? = 7
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
            HostCreationPriceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        binding.continueBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.addFragment(HostCreationFinalizeEventFragment(), true)
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
        binding.ivAdd.setOnClickListener {
            if (count!! < 8) {
                count = count!! + 1
            }
            binding.tvPrize.text = count.toString() + " €"
        }
        binding.ivRemove.setOnClickListener {
            if (count!! > 2) {
                count = count!! - 1
            }
            binding.tvPrize.text = count.toString() + " €"
        }

    }
}
/*

Screen: HostCreationPriceView

title:: Quel serais votre prix idéal par billets ?
----ExtraBold, ofSize: 28))

minus.circle
plus.circle
---size : 35

if selectedPrice >= 20 {
    Text("\(selectedPrice) €")
        .font(.type(style: .Bold, ofSize: 80))
    .foregroundColor(.red)
} else if selectedPrice <= 12 {
    Text("\(selectedPrice) €")
        .font(.type(style: .Bold, ofSize: 80))
    .foregroundColor(.green)
} else {
    Text("\(selectedPrice) €")
        .font(.type(style: .Bold, ofSize: 80))
    .foregroundColor(.white)
}

---- footnote --style: .Medium, ofSize: 12)

if selectedPrice >= 20 {
    Text("Billets trop cher")
        .foregroundColor(.white)
    .footnote()
        .padding(5)
        .background(Color.red.cornerRadius(12))

    Text("Les utilisateurs clubin trouveront un autre évènement avec les mêmes caractéristiques pour moins chère.")
        .footnote()

} else if selectedPrice <= 12 {

    Text("Billets attractifs")
        .foregroundColor(.white)
    .footnote()
        .padding(5)
        .background(Color.green.cornerRadius(12))

    Text("Les utilisateurs clubin vont trouveront votre évènement attractifs. ")
        .footnote()

} else {
    Text("Billets au bon prix")
        .foregroundColor(.white)
    .footnote()
        .padding(5)
        .background(Color.blue.cornerRadius(12))

    Text("Les utilisateurs clubin trouveront cet évènement au prix juste.")
        .footnote()
}

Button::
leftText: "Valider ce prix", rightImage: "arrow.right"
---onclick:: HostCreationPhotosPreviewView*/
