package Ex01

fun main () {
    val numerosDaSorte =
        mutableMapOf<Int, String>(
        0 to "Ovos", 1 to "Água",
        2 to "Escopeta",
        3 to "Cavalo",
        4 to "Dentista",
        5 to "Fogo")

    print(numerosDaSorte[2])
}