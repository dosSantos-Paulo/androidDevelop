

fun main () {
    print(comparar(1,3,2,2))
}

fun comparar (numA:Int, numB:Int, numC:Int, numD:Int) = numA > numC && numA > numD || numB > numC && numB > numD