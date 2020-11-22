package com.dossantosp.conversorfaren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnConverter.setOnClickListener {
            txtResposta.text = "${converterParaF(edtTemperatura.text.toString().toDouble())} ºF"
            edtTemperatura.text = null
        }


    }
}

fun converterParaF (temperaturaEmC: Double): Double {
    return (temperaturaEmC * 9 / 5) + 32
}
