package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_createAccountLogin.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()

            if (email.isBlank()){
                edt_email.error = "Digite um email"

            }

            if (password.isBlank()){
                edt_password.error = "Digite sua senha"
            }


            if (UserService.logIn(email, password) != null){
                val intent = Intent (this, BemVindoActivity::class.java)

                intent.putExtra("USER_EMAIL", email)
                intent.putExtra("USER_PASSWORD", password)

                startActivity(intent)
            } else {
                if (!email.isBlank() || !password.isBlank()) {
                    Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
                }
            }

            edt_email.text.clear()
            edt_password.text.clear()

        }
    }
}