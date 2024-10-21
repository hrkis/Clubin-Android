package com.clubin.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.clubin.com.ui.auth.login.view.LoginActivity
import com.clubin.com.ui.auth.onboarding.view.OnboardingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val inscription: TextView = findViewById(R.id.inscription)
        inscription.setOnClickListener {
            intent = Intent(applicationContext, OnboardingActivity::class.java)
            startActivity(intent)
        }

        val loginText: TextView = findViewById(R.id.loginText)
        loginText.setOnClickListener {
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}