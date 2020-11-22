package com.dossantosp.lab20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floating_action_button.setOnClickListener{
            Snackbar.make(minhaViewn, "Tentar novamente?", Snackbar.LENGTH_LONG)
                .setAction("Tentar") {
                    Toast.makeText(this,"Realizado", Toast.LENGTH_SHORT).show()
                }.show()
        }

        botao.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Clicou")
                .setMessage("Tem certeza que gostaria de clicar no botão?")
                .setNegativeButton("Não") {dialog, which ->
                    Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                }.setPositiveButton("Sim") {dialog, wich ->
                    Toast.makeText(this, "Clicou!!!", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}