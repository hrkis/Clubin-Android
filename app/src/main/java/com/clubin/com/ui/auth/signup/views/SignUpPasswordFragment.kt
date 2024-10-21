package com.clubin.com.ui.auth.signup.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.clubin.com.R
import com.clubin.com.databinding.SignUpPasswordFragmentDataBinding
import com.clubin.com.network.Resource
import com.clubin.com.ui.auth.login.model.User
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.ui.auth.login.view.LoginActivity
import com.clubin.com.ui.auth.signup.viewmodel.SignupVM
import com.clubin.com.utills.handleApiError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class SignUpPasswordFragment : BaseDataBindingFragment<SignUpPasswordFragmentDataBinding>
    (R.layout.fragment_sign_up_password), AccountEditFragmentCallback {

    private var user: User? = null
    private var param2: String? = null
    private val viewModel by viewModels<SignupVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getSerializable(ARG_PARAM1) as User?
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun injectDaggerComponent() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.registerResponse.observe(viewLifecycleOwner, Observer {
            // binding.progressbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {

                    }
                }
                is Resource.Failure -> handleApiError(it) { }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpPasswordFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {

        binding.button.setOnClickListener {
            var password = binding.editTextPassword.text.toString().trim()
            user?.let { it1 ->
                viewModel.register(it1.first_name + " " + it1.last_name,
                    it1.age, it1.email, password)
            }

            var intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finishAffinity();
        }
    }
}