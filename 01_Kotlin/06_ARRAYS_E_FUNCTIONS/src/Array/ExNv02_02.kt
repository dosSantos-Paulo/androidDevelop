package Array

fun main () {
    val notas = arrayListOf<Double>(100.00, 50.00, 10.00, 5.00, 1.00)

    print("Quanto você gostaria de sacar ?: ")
    var valor = readLine()!!.toDouble()

    for (i in 0 until notas.size ){

        if ((valor / notas[i]).toInt() == 1) {
            println("Você precisará de ${(valor / notas[i]).toInt()} nota de ${notas[i]}")
        } else if ((valor / notas[i]).toInt() > 1){
            println("Você precisará de ${(valor / notas[i]).toInt()} notas de ${notas[i]}")
        } else if ((valor / notas[i]).toInt() > 1){
            continue
        }

        valor %= notas[i]

    }

}