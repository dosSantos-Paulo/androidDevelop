package Functions

fun main () {
    print("Digite o custo do seu produto: ")
    var custo = readLine()!!.toDouble()
    print("E qual a taxa de imposto ? (%): ")
    var imposto = readLine()!!.toDouble()

    println(somaImposto(imposto, custo))
}

fun somaImposto (taxaImposto:Double, custo:Double) = custo + (custo * (taxaImposto / 100))
