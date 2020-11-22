package Functions

import kotlin.random.Random

fun main () {
    var contadorDeRodada = 1
    var numeroTirado = 0
    var numeroDaSorte = 0

    println(".....:::: CRAPS ::::.....")
    println("")

    do{


        print("Aperte ENTER para rolar os dados!")

        if (readLine()!! == ""){
            numeroTirado = rolarDados()
        } else {
            println("hm... botão errado ...")
            continue
        }


        println("Você tirou :::: [ $numeroTirado ]")

        if (contadorDeRodada == 1) {
            when (numeroTirado){
                7, 11 -> {
                    println (":::: NATURAL :::: ganhou o jogo!!!")
                    break
                }
                2, 3, 12 -> {
                    println(":::: CRAPS :::: perdeu o jogo!!!")
                    break
                }
                4, 5, 6, 8, 9, 10 -> {
                    println("Repita os números para ganhar")
                    numeroDaSorte = numeroTirado
                }

            }
        } else if (contadorDeRodada > 1) {
            when(numeroTirado){
                7 -> {
                    println(":::: CRAPS :::: perdeu o jogo!!!")
                    break
                }
                numeroDaSorte -> {
                    println("Você repetiu $numeroDaSorte :::: Ganhou o Jogo!!!")
                    break
                }
            }
        }

        contadorDeRodada++
    } while (true)

}

fun rolarDados() = Random.nextInt(2,12)