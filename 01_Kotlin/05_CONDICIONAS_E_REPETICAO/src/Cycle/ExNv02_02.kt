package Cycle

fun main() {
    print("Digite a quantidade de CDs: ")
    val qtdCDs = readLine()!!.toInt()

    var valorTotal = 0.0
    var valorEntrada = 0.0
    for(i in 1..qtdCDs) {
        print("Digite o valor do $i º CD: ")
        valorEntrada = readLine()!!.toDouble()

        valorTotal += valorEntrada
    }

    val valorMedio = valorTotal / qtdCDs

    println("Total investido: R$ $valorTotal")
    println("O valor médio é: R$ " + "%.2f".format(valorMedio))


}