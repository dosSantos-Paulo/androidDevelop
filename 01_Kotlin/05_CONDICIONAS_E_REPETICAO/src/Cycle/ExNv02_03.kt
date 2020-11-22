package Cycle

fun main() {
    var num = Int.MIN_VALUE
    do {
        print("Digite um número de 1 a 10 para ver sua tabuada: ")
        num = readLine()!!.toInt()

        if(num in 1..10) break

        println("Número inválido!")
    } while(true)

    for(i in 1..10) {
        println("$num X $i = " + (num*i))
    }


}