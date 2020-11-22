package Ex04_SaveTheRoupaSA

import java.lang.Exception

fun main () {

    val guardaVolume = GuardaVolume()

    val peca1 = Peca("Hering","Jaqueta")
    val peca2 = Peca("Douce Gabana", "Boné")
    val pecas = mutableListOf<Peca>(peca1, peca2)


    guardaVolume.guardarPecas(pecas)
    guardaVolume.mostrarPecas(1)
    guardaVolume.devolverPecas(1)
    guardaVolume.mostrarPecas(1)
    guardaVolume.guardarPecas(pecas)
    guardaVolume.mostrarPecas(1)


}