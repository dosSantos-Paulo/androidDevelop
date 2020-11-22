package Ex03

class Prova () {

    fun somaTotal(conjuntoDeInteiros: MutableSet<Int>): Int {
        var soma = 0
        conjuntoDeInteiros.forEach{
            soma += it
        }

        return soma
    }
}