package com.clubin.com.ui.auth.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.clubin.com.R
import com.clubin.com.network.Resource
import com.clubin.com.ui.auth.login.viewmodel.LoginVM
import com.clubin.com.ui.auth.passwordreset.view.PasswordResetEmailActivity
import com.clubin.com.ui.tabbar.TabBarActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textViewDetails: TextView = findViewById(R.id.textViewDetails)
        textViewDetails.setOnClickListener {
            intent = Intent(applicationContext, PasswordResetEmailActivity::class.java)
            startActivity(intent)
        }
        val button: TextView = findViewById(R.id.button)
        button.setOnClickListener {
         //   login();
            intent = Intent(applicationContext, TabBarActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

        viewModel.loginResponse.observe(this, Observer {
            //  binding.progressbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                      /*  viewModel.saveAccessTokens(
                            it.value.user.access_token!!,
                            it.value.user.refresh_token!!
                        )*/
                        // requireActivity().startNewActivity(HomeActivity::class.java)
                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun login() {
        val email: TextView = findViewById(R.id.editTextEmailAddress)

        val password: TextView = findViewById(R.id.editTextPassword)

        if (email.text.isEmpty()) {
            Toast.makeText(this, "Please enter the email", Toast.LENGTH_SHORT).show()
        } else if (password.text.isEmpty()) {
            Toast.makeText(this, "Please enter the password", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.login(email.text.toString().trim(),
                password.text.toString().trim())
        }
    }

}