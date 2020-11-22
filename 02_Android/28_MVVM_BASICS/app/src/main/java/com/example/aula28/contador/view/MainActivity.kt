package com.example.aula28.contador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aula28.R
import com.example.aula28.contador.viewmodel.ContadorViewModel
import com.example.aula28.contador.viewmodel.ContadorViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var _viewModel: ContadorViewModel
    
    private val _texto by lazy {findViewById<TextView>(R.id.txt_texto)}
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUi()

    }
    
    
    fun setupViewModel() {
        Log.i(TAG, "setupViewModel")

        _viewModel = ViewModelProvider(
            this,
            ContadorViewModelFactory()
        ).get(ContadorViewModel::class.java)
        
        _viewModel.contador.observe(this, alterarTexto)
        
    }
    
    private val alterarTexto = Observer<Double> {

        _texto.text = "%.2f".format(it).toString()
    }

    private fun setupUi() {
        Log.i(TAG, "setupUi")



        val btnAdiciona = findViewById<Button>(R.id.btn_adiciona)
        val btnSubtrai = findViewById<Button>(R.id.btn_subtrai)
        val btnMultiplica = findViewById<Button>(R.id.btn_multiplica2)
        val btnDivide = findViewById<Button>(R.id.btn_divide2)
//        var valor = edt_valor


        btnAdiciona.setOnClickListener {
            _viewModel.incrementar(checkButton())
        }

        btnSubtrai.setOnClickListener {
            _viewModel.subtrair(checkButton())
        }

        btnMultiplica.setOnClickListener {

            _viewModel.multiplicar(checkButton())

        }

        btnDivide.setOnClickListener {

            _viewModel.divide(checkButton())
        }
    }

    private fun checkButton(): Int {
        var valor: Int = 0
        when {
            btn_1.isChecked -> valor = btn_1.text.toString().toInt()
            btn_2.isChecked -> valor = btn_2.text.toString().toInt()
            btn_3.isChecked -> valor = btn_3.text.toString().toInt()
            btn_4.isChecked -> valor = btn_4.text.toString().toInt()
            btn_5.isChecked -> valor = btn_5.text.toString().toInt()
            btn_7.isChecked -> valor = btn_7.text.toString().toInt()
            btn_8.isChecked -> valor = btn_8.text.toString().toInt()
            btn_9.isChecked -> valor = btn_9.text.toString().toInt()
            btn_10.isChecked -> valor = btn_10.text.toString().toInt()
        }
        return valor
    }
    
    companion object {
        const val TAG = "AULA28::MAIN_ACTIVITY"
    }
}