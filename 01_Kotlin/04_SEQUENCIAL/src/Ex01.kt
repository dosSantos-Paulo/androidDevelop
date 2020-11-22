fun main () {
    println("Vamos calcular sua média anual ?")

    print("Qual foi sua nota no 1º Sem: ")
    var nota1 = readLine()!!.toDouble()

    print("Qual foi sua nota no 2º Sem: ")
    var nota2 = readLine()!!.toDouble()

    print("Qual foi sua nota no 3º Sem: ")
    var nota3 = readLine()!!.toDouble()

    print("Qual foi sua nota no 4º Sem: ")
    var nota4 = readLine()!!.toDouble()

    var media = (nota1 + nota2 + nota3 + nota4) / 4

    print("Sua média é : " + "%.2f".format(media))

}