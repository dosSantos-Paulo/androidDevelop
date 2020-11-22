package Functions

fun main () {
    var numero = arrayListOf<Int>()
    for (i in 1..3){
        print("Digite um ${i}º número: ")
        numero.add(readLine()!!.toInt())
    }
    somar(numero[0], numero[1], numero[2])
}

fun somar (num1:Int, num2:Int, num3:Int) = print("A soma dos 3 valores é ${num1 + num2 + num3}")