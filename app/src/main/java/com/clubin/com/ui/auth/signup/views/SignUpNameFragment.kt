package com.clubin.com.ui.auth.signup.views

import android.os.Bundle

import com.clubin.com.R
import com.clubin.com.databinding.SignUpNameFragmentDataBinding
import com.clubin.com.ui.auth.login.model.User
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class SignUpNameFragment : BaseDataBindingFragment<SignUpNameFragmentDataBinding>
    (R.layout.fragment_sign_up_name), AccountEditFragmentCallback {

    private var user: User? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getSerializable(ARG_PARAM1) as User?
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun injectDaggerComponent() {

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpNameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {

        binding.button.setOnClickListener {
            var firstName = binding.editTextFirstName.text.toString().trim();
            var lastName = binding.editTextLastName.text.toString().trim();
            var userNew = user?.let {
                User(firstName, lastName, "", it.age, "")
            }
            if (userNew != null) {
                fragmentChange(SignUpEmailFragment(), userNew, "", "")
            }
        }
    }
}