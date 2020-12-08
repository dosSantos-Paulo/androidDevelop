package com.example.shared_preferences

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.shared_preferences.MainActivity.Companion.EMAIL_KEY
import com.example.shared_preferences.MainActivity.Companion.EMAIL_PREFS
import com.example.shared_preferences.MainActivity.Companion.PASS_PREFS
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class WellcomeActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wellcome)

        val getEmail = intent.getStringExtra(EMAIL_KEY).toString()
        val wellcome = findViewById<TextView>(R.id.txt_wellcome)
        val exitButton = findViewById<Button>(R.id.btn_exit)
        val keepConnectedPreferences =
            getSharedPreferences(MainActivity.KEEP_CONNECTED_PREFS, MODE_PRIVATE)

        wellcome.text = "Bem vindo $getEmail"

        exitButton.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Sair ?")
                .setMessage("Você clicou em sair, tem certeza disso?")
                .setPositiveButton("Sim") { _, _ ->
                    keepConnectedPreferences.edit()
                        .putString(EMAIL_PREFS, "")
                        .putString(PASS_PREFS, "")
                        .apply()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Não") { _, _ ->
                    closeContextMenu()
                }
                .show()

        }


    }
}