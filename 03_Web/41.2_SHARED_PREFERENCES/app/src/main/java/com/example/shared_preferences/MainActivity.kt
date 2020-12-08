package com.example.shared_preferences

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<MaterialButton>(R.id.btn_login_main)
        val email = findViewById<TextInputLayout>(R.id.editT_email_main)
        val password = findViewById<TextInputLayout>(R.id.editT_password_main)
        val rememberBox = findViewById<CheckBox>(R.id.checkbox_remember_main)

        val keepConnectedPreference = getSharedPreferences(KEEP_CONNECTED_PREFS, MODE_PRIVATE)

        rememberBox.setOnCheckedChangeListener { _, isChecked ->
            keepConnectedPreference.edit()
                .putString(EMAIL_PREFS, email.editText?.text.toString())
                .putString(PASS_PREFS, password.editText?.text.toString())
                .apply()

        }

        loginButton.setOnClickListener {
            val intent = Intent(this, WellcomeActivity::class.java)
            intent.putExtra(EMAIL_KEY, email.editText?.text.toString())
            startActivity(intent)
        }

    }

    companion object {
        const val EMAIL_PREFS = "EMAIL"
        const val PASS_PREFS = "PASSWORD"
        const val KEEP_CONNECTED_PREFS = "SAVE_LOGIN_PREFERENCES"

        const val EMAIL_KEY = "EMAIL"
    }
}