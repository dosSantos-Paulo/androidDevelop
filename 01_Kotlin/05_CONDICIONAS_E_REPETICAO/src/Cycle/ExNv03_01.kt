package Cycle

import kotlin.math.max
import kotlin.math.min

fun main () {
    var maisAlto = Double.MIN_VALUE
    var maisBaixo = Double.MAX_VALUE
    var maisMagro = Double.MAX_VALUE
    var maisGordo = Double.MIN_VALUE
    var peso = Double.MIN_VALUE
    var altura = Double.MIN_VALUE

    println("Olá, vamos iniciar a pesquisa para saber os mais altos, baixos, magros e gordinhos " +
            "da nossa academia")

    do {

        println("Para encerrar, digite '0' ou...")
        print("Digite o seu código do usuário para inserir novos dados: ")

        var codigo = readLine()!!.toInt()

        if (codigo == 0) break

        print("Digite o seu peso (Ex: 68.2): ")

        peso = readLine()!!.toDouble()
        maisGordo = max(maisGordo, peso)
        maisMagro = min(maisMagro, peso)

        print("Digite o sua altura (Ex: 1.78): ")

        altura = readLine()!!.toDouble()
        maisAlto = max(maisAlto, altura)
        maisBaixo = min(maisBaixo, altura)

    }while(true)

    println("Os Resultados finais foram:")
    println("O Atleta mais alto tem $maisAlto m")
    println("O Atleta mais baixo tem $maisBaixo m")
    println("O Atleta mais magro tem $maisMagro kg")
    println("O Atleta mais gordinho tem $maisGordo kg")
}