package Array

fun main () {
    var altura = arrayListOf<Double>()

    for (i in 1..5) {
        print("Digite a sua altura: ")
        altura.add(readLine()!!.toDouble())
    }

    altura.reverse()

    altura.forEach(){altura ->
        println("%.2f".format(altura))
    }
}