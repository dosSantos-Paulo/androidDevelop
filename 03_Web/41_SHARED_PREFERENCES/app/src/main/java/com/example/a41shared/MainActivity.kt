package com.example.a41shared

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switch = findViewById<Switch>(R.id.switch_habilitarNotificacoes)
        val preferences = getSharedPreferences(APP_NAME, MODE_PRIVATE)
        val preferChecked = preferences.getBoolean("NOTIFICATION_PREFS", false)
        val text = findViewById<TextView>(R.id.txt_text)

        switch.isChecked = preferChecked
        text.text = preferChecked.toString()

        switch.setOnCheckedChangeListener { _, isChecked ->
            preferences.edit().putBoolean(NOTIFICATION_PREFS, isChecked).apply()
            text.text = isChecked.toString()
        }
    }

    companion object {
        const val APP_NAME = "Aula41_prefs"
        const val NOTIFICATION_PREFS = "NOTIFICATION_PREFS"
    }
}