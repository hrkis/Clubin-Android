package com.clubin.com.ui.fragment.profile.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.PaymentHistoryFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.PaymentHistoryFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PaymentHistoryFragment : BaseDataBindingFragment<PaymentHistoryFragmentDataBinding>
    (R.layout.fragment_payment_history),
    PaymentHistoryFragmentCallback {
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
Screen : Paiements (MenuPaymentHistory)
opens on click :: --- MenuView - Paiement - Paiements

nav title: Paiements

view 1: historyHeader

Retrouvez ici toutes vos réservations, ainsi que vos remboursements déjà effectués et en cours, de cette années.
-----(style: .Medium, ofSize: 12) secondary color

- Divider - color - accent - 2CD0A8 cornerRadius(20)

- tableview - transferData
- cell

Text(history.date)
.headline()
Text(history.name)
.body()

Text(history.money)
.headline()
Text(history.nbPlace)
.body()


model and dummy values:::

struct HistoryPayment: Identifiable {
    var id = UUID()
    var nbPlace: String
    var name: String
    var pic: String
    var event: String
    var date: String
    var money: String
    var when: String
}


let historyPaymentData: [HistoryPayment] = [
HistoryPayment(nbPlace: "1", name: "Paris", pic: "Paris", event: "Best Wine Party Ever", date: "29/10/2020", money: "18 €", when: "04/11/2020"),
HistoryPayment(nbPlace: "1", name: "Annie", pic: "Annie", event: "Big fiesta", date: "29/10/2020", money: "18 €", when: "04/11/2020"),
HistoryPayment(nbPlace: "2", name: "Alex", pic: "Alex", event: "DJ Period", date: "29/10/2020", money: "18 €", when: "04/11/2020")
]*/
