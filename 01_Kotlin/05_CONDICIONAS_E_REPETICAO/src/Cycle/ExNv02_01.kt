package Cycle

fun main() {
    print("Digite a quantidade de notas: ")
    val qtdNotas = readLine()!!.toInt()

    var somaNotas = 0
    var notaEntrada = 0
    for(i in 1..qtdNotas) {
        print("Digite a $i ª nota: ")
        notaEntrada = readLine()!!.toInt()

        somaNotas += notaEntrada
    }

    val media = somaNotas / qtdNotas

    println("A média é: $media")
}