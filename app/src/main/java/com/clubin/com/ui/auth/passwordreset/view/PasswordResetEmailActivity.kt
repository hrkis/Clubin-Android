package com.clubin.com.ui.auth.passwordreset.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.clubin.com.R

class PasswordResetEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset_email)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            intent = Intent(applicationContext, PasswordResetCodeActivity::class.java)
            startActivity(intent)
        }
    }
}
/*

    Screen:: PasswordResetEmailView

    Mot de passe oublié ?
    ----style: .ExtraBold, ofSize: 28))

    Entrez votre e-mail associé à ce compte pour recevoir votre code de validation
    -----style: .Medium, ofSize: 16))

Textfield placeholder::: E-mail
Vous n'avez plus accès à cet e-mail ?\nMerci de contacter notre Service Client depuis le Centre d'aide.

------fontsize : 16 regular
Vous n'avez plus accès à cet e-mail ?"
+
Service Client

-----fontsize:: 16 bold
Centre d'aide

----font size : 16 bold
------color: lighblue - light mode - 66D6FF and dark mode - 66D6FF
-----static let helpCenter = "https://apple.com"

Apple
https://apple.com


last button:: Envoyer le code
*/


