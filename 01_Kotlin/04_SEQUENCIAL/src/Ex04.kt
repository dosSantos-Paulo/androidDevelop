import kotlin.math.max

fun main () {

    println("Gostaria de Calcular quanto vai pagar pelo excesso?")

    print("Quanto você pescou hoje? ")
    var kilosDePeixe = readLine()!!.toDouble()

    var excesso = max(0.00 , (kilosDePeixe - 50.00))


    println ("Você excedeu $excesso Kg")

    println("Então você pagará: R$ " + (excesso * 4.00))

}