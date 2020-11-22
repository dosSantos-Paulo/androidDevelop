

fun main () {
    var numero = -245

    while (numero <= 100) {
        if (ehPositivo(numero)){
            println(numero)
            numero++
        } else{
            numero++
        }
    }
}

fun ehPositivo (numero:Int) = numero > 0
