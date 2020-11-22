package Conditions
import kotlin.math.min

fun main () {

    val numeroTotalDeNotas = 2

    print("Digite a sua 1ª nota: ")
    var nota1 = min(10.00, readLine()!!.toDouble())

    print("Digite a sua 2ª nota: ")
    var nota2 = min(10.00, readLine()!!.toDouble())

    when {
        ((nota1 + nota2) / 2) == 10.00 -> {
            print("Aprovado com distinção")
        }
        ((nota1 + nota2) / 2) >= 7.00 -> {
            print("Aprovado")
        }
        else -> print("reprovado")
    }
}