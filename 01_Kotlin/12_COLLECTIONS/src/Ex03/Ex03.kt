package Ex03

fun main () {
    val prova = Prova()

    print(prova.somaTotal(mutableSetOf<Int>(1, 2, 3, 4, 5)))
    print(prova.somaTotal(mutableSetOf<Int>(1, 1, 1, 1, 1)))
}