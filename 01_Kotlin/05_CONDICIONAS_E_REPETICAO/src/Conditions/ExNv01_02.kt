package Conditions

fun main (){

    print("Digite um número: ")

    when (readLine()!!.toInt() % 2){
        0 -> print("Você digitou um número par")
        else -> print("Você digitou um número ímpar")
    }
}