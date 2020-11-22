package com.dossantosp.obtendoelementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.dossantosp.obtendoelementos.R.string
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nome = edtNome.text

        btnExibir.setOnClickListener {
            txtResposta.text = getString(R.string.resposta, nome)
        }

    }

}