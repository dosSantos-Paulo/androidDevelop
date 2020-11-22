package Escola

class Aluno (private val nome: String,
             private val sobrenome: String,
             private val rA: Int) {

    val podeAssistirAula: Boolean
        get() = true

    val podeFazerLicao: Boolean
        get() = true

}