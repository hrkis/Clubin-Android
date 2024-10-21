package com.clubin.com.ui.auth.passwordreset.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.clubin.com.R

class PasswordResetCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset_code);

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            intent = Intent(applicationContext, PasswordResetNewPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}
/*
 PasswordResetCodeView

Entrez votre code

Un code de réinitialisation vous a était envoyé par email.

Code

Vous n'avez pas reçu de code ?\nEssayer d'actualiser votre boite mail et
 de vérifier vos spams.\nSi le problème persiste, merci de contacter notre Centre d'aide.
-- Vous n'avez pas reçu de code ? ------- 16 bold
-- Centre d'aide ---------- 16 bold, lighblue color and link not provided

Valider -------- font - title2, bold
--button UI --------(cornerRadius: 10)
.padding(.horizontal)
.frameFullWidth()
.frame(maxHeight: 50)
.frame(minHeight: 30)*/