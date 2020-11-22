package Exercicio05

import java.lang.Exception
import java.lang.IndexOutOfBoundsException

fun main () {
    var novaLista = arrayListOf("Pato", "Cachorro", "Gato")

    try {
        print(novaLista.get(3))
    } catch (ex: IndexOutOfBoundsException){
        println(ex.message)
        ex.printStackTrace()
    } catch (ex: Exception){
        println("Deu ruim")
    }

}