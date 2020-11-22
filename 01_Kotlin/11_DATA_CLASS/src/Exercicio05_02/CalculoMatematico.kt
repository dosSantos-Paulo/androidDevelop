package Exercicio05_02

class CalculoMatematico {
    fun divisao (dividendo: Int, divisor: Int): Int {
        if (divisor == 0) {
            throw java.lang.ArithmeticException("A operação não pode ser realizada")
        }
        return dividendo / divisor
    }
}