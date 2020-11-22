class ContaCorrente (numeroDaConta: Int,
                     saldo:Double,
                    private var taxaDeOperacao: Double):
                    Contas(numeroDaConta, saldo) {

    override fun sacar (valor:Double): Boolean {


        when {
            (valor <= (saldo - taxaDeOperacao)) -> {
                saldo -= valor + taxaDeOperacao
                return true
            }
            (valor > (saldo - taxaDeOperacao)) -> {
                println("Saldo Insuficiente")
                return false
            } else -> return false
        }

    }


    override fun depositar (valor: Double) {
        if (valor + saldo > taxaDeOperacao){
            saldo += valor - taxaDeOperacao
        } else {
            println("Valor de deposito insuficiente")
        }

    }

    override fun mostrarDados() {
        super.mostrarDados()
        println("taxa de operação: R$ $taxaDeOperacao")
    }

}