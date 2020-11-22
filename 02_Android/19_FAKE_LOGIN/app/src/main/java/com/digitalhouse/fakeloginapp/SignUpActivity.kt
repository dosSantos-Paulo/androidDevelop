package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        check_iHaveRead.setOnCheckedChangeListener { _, isChecked ->
            btn_signUpToSign.isEnabled = isChecked
        }

        btn_loginSignUp.setOnClickListener {
            finish()
        }

        btn_signUpToSign.setOnClickListener {
            val name = edt_nomeSignUp.text.toString()
            val email = edt_emailSignUp.text.toString()
            val password = edt_passwordSignUp.text.toString()

            try {
                UserService.register(name, email, password)
                finish()
            } catch (ex: Exception) {
                Toast.makeText(this, "${ex.message}", Toast.LENGTH_SHORT).show()
            }



        }
    }
}