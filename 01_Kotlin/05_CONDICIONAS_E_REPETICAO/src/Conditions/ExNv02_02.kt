package Conditions

fun main () {
    val valorMaximoParaSaque = 600.00
    val valorMinimoParaSaque = 10.00
    val cemReais = 100.00
    val cinquentaReais = 50.00
    val dezReais = 10.00
    val cincoReais = 5.00
    val umReal = 1.00


    print("Quanto você gostaria de sacar?")
    var saque = readLine()!!.toDouble()

    if (saque > valorMaximoParaSaque || saque < valorMinimoParaSaque){
        print("Você precisa sacar um valor entre R$${"%.2f" .format(valorMinimoParaSaque)} " +
                "e R$${"%.2f".format(valorMaximoParaSaque)}")
    } else if (saque < valorMaximoParaSaque || saque > valorMinimoParaSaque){

        var notasDeCem = (saque / cemReais).toInt()
        var restoDeCem = saque % cemReais

        var notasDeCinquenta = (restoDeCem / cinquentaReais).toInt()
        var restoDeCinquenta = restoDeCem % cinquentaReais

        var notasDeDez = (restoDeCinquenta / dezReais).toInt()
        var restoDeDez = restoDeCinquenta % dezReais

        var notasDeCinco = (restoDeDez / cincoReais).toInt()
        var notasDeUm = restoDeDez % cincoReais

        println("Então, você vai sacar :")

        when {
            (notasDeCem > 1) -> println("$notasDeCem notas de R$ $cemReais")
            (notasDeCem == 1) -> println("$notasDeCem nota de R$ $cemReais")
        }

        when {
            (notasDeCinquenta > 1) -> println("$notasDeCinquenta notas de R$ $cinquentaReais")
            (notasDeCinquenta == 1) -> println("$notasDeCinquenta nota de R$ $cinquentaReais")
        }

        when {
            (notasDeCinquenta > 1) -> println("$notasDeCinquenta notas de R$ $cinquentaReais")
            (notasDeCinquenta == 1) -> println("$notasDeCinquenta nota de R$ $cinquentaReais")
        }

        when {
            (notasDeDez > 1) -> println("$notasDeDez notas de R$ $dezReais")
            (notasDeDez == 1) -> println("$notasDeDez nota de R$ $dezReais")
        }

        when {
            (notasDeCinco > 1) -> println("$notasDeCinco notas de R$ $cincoReais")
            (notasDeCinco == 1) -> println("$notasDeCinco nota de R$ $cincoReais")
        }

        when {
            (notasDeUm.toInt() > 1) -> println("${notasDeUm.toInt()} notas de R$ $umReal")
            (notasDeUm.toInt() == 1) -> println("${notasDeUm.toInt()} nota de R$ $umReal")
        }

    }
}