
fun main () {
    var contador = 200
    var numero = -500

    for (i in numero until contador){

        if (impares(numero)) {

            println(numero)
            numero++

        } else if (!(impares(numero))) {
            numero++
        }

    }
}

fun impares (numero:Int) = numero % 2 != 0 && numero > 0
