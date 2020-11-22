package Cycle

import kotlin.math.max
import kotlin.math.min

fun main () {
    print("Digite o 1º número: ")
    val num1 = readLine()!!.toInt()

    print("Digite o 2º número: ")
    val num2 = readLine()!!.toInt()

    for(i in min(num1, num2)..max(num1, num2)) {
        println(i)
    }
}