package Functions

fun main () {

    print("Digite um número: ")
    ehNegativoOuPositivo(readLine()!!.toInt())
}

fun ehNegativoOuPositivo(num:Int) = if (num <= 0) println("N") else print("P")