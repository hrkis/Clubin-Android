package com.clubin.com.ui.auth.passwordreset.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.clubin.com.R
import com.clubin.com.ui.auth.login.view.LoginActivity

class PasswordResetNewPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset_new_password)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}