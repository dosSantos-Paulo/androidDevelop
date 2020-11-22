package Conditions

fun main () {

    print("Qual o seu sexo biológico: ")
    var sexo: String = readLine()!!.toUpperCase()

    if (sexo == "F" || sexo == "FEMININO") print("Você digitou feminino")
    else if (sexo == "M" || sexo == "MASCULINO") print("Você digitou masculino")
    else print("você precisa digitar 'F' ou 'M' ")

}