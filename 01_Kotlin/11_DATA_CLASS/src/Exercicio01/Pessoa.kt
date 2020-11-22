package Exercicio01

class Pessoa (val nome: String,
              val rG: Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pessoa

        if (rG != other.rG) return false

        return true
    }

    override fun hashCode(): Int {
        return rG
    }
}