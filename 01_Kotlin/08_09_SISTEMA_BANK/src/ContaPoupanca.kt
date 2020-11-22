class ContaPoupanca (numeroDaConta: Int,
                     saldo:Double,
                     private var limite: Double):
                    Contas(numeroDaConta, saldo) {

    override fun sacar (valor:Double): Boolean {

        return when {

            (valor <= saldo) -> {
                saldo -= valor
                return true
            }
            (valor <= (saldo + limite)) -> {
                saldo -= valor
                return true
            }
            (valor > (saldo + limite)) -> {
                println("Saldo insuficiente")
                return false
            }
            else -> return false
        }
    }

    override fun depositar (valor: Double) {
        saldo += valor
    }

    override fun mostrarDados() {
        super.mostrarDados()
        println("Saldo + Limite: R$ ${saldo + limite}")
    }
}