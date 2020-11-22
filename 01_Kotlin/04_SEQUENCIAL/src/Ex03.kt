fun main () {
    println("Gostaria de calcular seu peso ideal?")

    print("Qual é a sua altura? (ex: 1.72) /// altura = ")
    var altura = readLine()!!.toDouble()

    var paraHomes = "%.2f" .format((72.7 * altura) - 58)
    var paraMulheres = "%.2f" .format((62.1 * altura) - 44.7)

    println("De acordo com a sua altura, o peso peso ideal é:")
    println("• Para Homens: $paraHomes")
    println("• Para Mulheres: $paraMulheres")
}