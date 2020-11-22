fun main () {
    println("Gostaria de saber quanto vai ganhar ?")

    print("Quanto vale a sua hora ? ")
    var valorHora = readLine()!!.toDouble()

    print("Quantas horas você trabalhou? ")
    var horasTotais = readLine()!!.toDouble()

    var salarioBruto = valorHora * horasTotais

    print("Você receberá R$$salarioBruto")
}