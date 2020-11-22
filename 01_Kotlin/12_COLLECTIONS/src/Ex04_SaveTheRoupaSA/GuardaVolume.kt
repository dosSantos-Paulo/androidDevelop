package Ex04_SaveTheRoupaSA

import java.lang.Exception
import kotlin.collections.MutableList

class GuardaVolume() {

    private var dicionarioDeVolume: MutableMap<Int, MutableList<Peca>> = mutableMapOf()
    private var contador: Int = 0

    fun guardarPecas(listaDePecas: MutableList<Peca>): Int {
        contador++
        if (!dicionarioDeVolume.containsKey(contador)){
            dicionarioDeVolume.put(contador, listaDePecas)
            println("Suas peças foram guardadas no guarda volume de " +
                    "nª: ${contador}")
            println()
            return contador

        } else {
            println("ERRO: numero de acesso duplicado!")
            return -1
        }


    }

    fun mostrarPecas(key: Int): Boolean {
        return if (dicionarioDeVolume.containsKey(key)){
            println("Peças do volume $key")
            println()
            println(dicionarioDeVolume[key]?.forEach {
                println("Marca: ${it.marca}")
                println("Modelo: ${it.modelo}")
                println()})
            true

        } else {
            println("ERRO: Não existem peças no volume $key")
            false
        }
    }

    fun devolverPecas(key: Int): Boolean {
        return if (dicionarioDeVolume.containsKey(key)){
            contador--
            dicionarioDeVolume.remove(key)
            println("Peças Devolvidas")
            println()
            true

        } else {
            println("ERRO: Não foi possível remover item")
            false
        }
    }
}