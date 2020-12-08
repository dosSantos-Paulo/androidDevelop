package com.example.shared_preferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.shared_preferences.MainActivity.Companion.EMAIL_KEY
import com.example.shared_preferences.MainActivity.Companion.EMAIL_PREFS
import com.example.shared_preferences.MainActivity.Companion.KEEP_CONNECTED_PREFS
import com.example.shared_preferences.MainActivity.Companion.PASS_PREFS

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val keepConnectedPreferences = getSharedPreferences(KEEP_CONNECTED_PREFS, MODE_PRIVATE)
        val email = keepConnectedPreferences.getString(EMAIL_PREFS, "")
        val password = keepConnectedPreferences.getString(PASS_PREFS, "")

        Handler(Looper.getMainLooper()).postDelayed({

            if (email.equals("") && password.equals("")) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else if (!email.equals("") && !password.equals("")) {
                val intent = Intent(this, WellcomeActivity::class.java)
                intent.putExtra(EMAIL_KEY, email)
                startActivity(intent)
                finish()
            }

        }, SPLASH_TIME)
    }

    companion object {
        const val SPLASH_TIME: Long = 3000
    }
}

