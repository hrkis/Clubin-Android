package com.clubin.com.ui.fragment.profile.views

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.databinding.UserReviewFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.event.model.EventModel
import com.clubin.com.ui.fragment.profile.adapter.UserReviewAdapter
import com.clubin.com.ui.fragment.profile.callbacks.ContactUsFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class UserReviewFragment : BaseDataBindingFragment<UserReviewFragmentDataBinding>
    (R.layout.fragment_user_review),
    ContactUsFragmentCallback {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    val list: MutableList<EventModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun injectDaggerComponent() {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserReviewFragment().apply {
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
        binding.ivCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
        setAdapter();
    }

    private fun setAdapter() {
        val adapter = UserReviewAdapter(mContext, list)
        var layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)

        binding.viewRecycler.layoutManager = layoutManager
        binding.viewRecycler.adapter = adapter


    }
}

/*
--- 4. UserReviewView
title: "Avis", seeMoreText: "Voir tout les avis"

----table - cell ---
ImageCircleComponent(image: "Profil", size: 50)
name --- (style: .Medium, ofSize: 16)
Image(systemName: "star.fill")
I bought this book to understand about the thought process in Ansel's mind.
 But was disappointed to
see that all that has been explained is about the stories behind those photographs.
--- style: .SemiBold, ofSize: 13) secondary color*/
