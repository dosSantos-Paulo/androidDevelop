abstract class Contas (var numeroDaConta: Int,
                       protected var saldo: Double): IImprimivel {

    abstract fun sacar (valor:Double) :Boolean

    abstract fun depositar (valor: Double)

    open fun transferir (valor: Double, conta: Contas) {

        var resultado = sacar(valor)

        if (resultado){
            conta.depositar(valor)
        }else if (resultado){
            println("Não é possível realizar a transferência")
            depositar(valor)
        }

    }

    override fun mostrarDados() {
        println("Numero da Conta: $numeroDaConta")
        println("Saldo: R$ $saldo")
    }
}