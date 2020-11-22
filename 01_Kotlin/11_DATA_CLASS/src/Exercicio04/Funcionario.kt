package Exercicio04

class Funcionario (val nome: String,
                   val numeroDeRegistro: Int){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Funcionario

        if (numeroDeRegistro != other.numeroDeRegistro) return false

        return true
    }

    override fun hashCode(): Int {
        return numeroDeRegistro
    }
}