package Cycle

import kotlin.math.max

fun main (){
    var contador = 1
    var resultado = Int.MIN_VALUE
    val contadorFinal = 5

    while(contador <= contadorFinal){
        print("Digite o ${contador}º número: ")
        resultado = max(readLine()!!.toInt(), resultado)
        contador++
    }

    print("O maior número digitado foi $resultado")
}