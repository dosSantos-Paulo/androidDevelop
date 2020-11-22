package Escola

class Professor (private val nome: String,
                 private val rD: Int) {
    val darAula: Boolean
        get() = true

    val fazerChamada: Boolean
        get() = true

}