package com.example.aula28.contador.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    var contador = MutableLiveData<Double>()

    init {
        contador.value = 0.0
    }

    fun incrementar (valor:Int) {
        contador.value = contador.value!! + valor
    }

    fun subtrair (valor:Int) {
        contador.value = contador.value!! - valor
    }

    fun multiplicar(valor:Int) {
        contador.value = contador.value!! * valor
    }

    fun divide(valor:Int) {
        contador.value = contador.value!! / valor
    }

}