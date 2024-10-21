package com.clubin.com.ui.auth.signup.views

import android.os.Bundle
import android.util.Log
import com.clubin.com.R
import com.clubin.com.databinding.SignUpAgeFragmentDataBinding
import com.clubin.com.ui.auth.login.model.User
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class SignUpAgeFragment : BaseDataBindingFragment<SignUpAgeFragmentDataBinding>
    (R.layout.fragment_sign_up_age), AccountEditFragmentCallback {

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
            SignUpAgeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        binding.button.setOnClickListener {
            var age = binding.editTextTextAge.text.toString().trim()
            Log.d("age", age);
            var user = User("", "", "", age, "")
            fragmentChange(SignUpNameFragment(), user, "", "")
        }
    }

    override fun onBackPress(): Boolean {
        requireActivity().finish();

        return true;
    }
}