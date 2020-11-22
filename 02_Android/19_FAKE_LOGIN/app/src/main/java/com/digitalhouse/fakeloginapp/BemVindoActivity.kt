package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_bem_vindo.*

class BemVindoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bem_vindo)

        val userEmail = intent.getStringExtra("USER_EMAIL").toString()
        val userPassword = intent.getStringExtra("USER_PASSWORD").toString()

        val usuario = UserService.logIn(userEmail, userPassword)!!

        txt_name_welcome.text = "Seja bem vindo ${usuario.name}"
    }
}