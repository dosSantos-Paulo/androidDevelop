package Ex01

fun main () {
    val amigos =
        mapOf<String, String>(
        "João" to "Juan, Fissura, Maromba",
        "Miguel" to "Night Watch, Bruce Wayne, Tampinha",
        "Maria" to "Wonder Woman, Mary, Marilene",
        "Lucas" to "Lukinhas, Jorge, George")

    amigos.forEach{
        println(it)
    }
}