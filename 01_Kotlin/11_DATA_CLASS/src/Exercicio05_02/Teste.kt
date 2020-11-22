package Exercicio05_02

import java.lang.ArithmeticException
import java.lang.Exception

fun main () {
    val calculoMatematico = CalculoMatematico()


    try {
        println(calculoMatematico.divisao(4, 0))
    } catch (ex: ArithmeticException) {
        println(ex.message)
    } catch (ex: Exception) {
        println(ex.message)
    }

}