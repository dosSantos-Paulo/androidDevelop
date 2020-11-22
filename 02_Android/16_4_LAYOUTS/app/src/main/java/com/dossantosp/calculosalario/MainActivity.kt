package com.dossantosp.calculosalario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {

            val horas = edtHorasTrabalhadas.text.toString()
            val valor = edtValorHora.text.toString()

            if (horas.isBlank()) {
                edtHorasTrabalhadas.error = "Coloque as horas trabalhadas"
            } else if (valor.isBlank()) {
                edtValorHora.error = "Coloque o valor da sua hora"
            } else if (!horas.isBlank() || !valor.isBlank()){
                var salario = horas.toDouble() * valor.toDouble()

                txtResposta.text = salario.toString()
                edtHorasTrabalhadas.text.clear()
                edtValorHora.text.clear()
                
            } else {
                Toast.makeText(this, "Complete todos os valores", Toast.LENGTH_SHORT).show()
                txtResposta.text = ""
            }


        }
    }
}
