class Banco: IImprimivel {
    private var listaDeContas = arrayListOf<Contas> ()

    fun inserir (conta: Contas) = listaDeContas.add(conta)

    fun remover (conta: Contas) {
        for (i in 0 until listaDeContas.size){
            if (conta.numeroDaConta == listaDeContas[i].numeroDaConta){
                listaDeContas.removeAt(i)
                println("Conta removida com sucesso")
                return
            }
        }
        println("Esta conta não foi encontrada")
        return
    }

    fun procurarConta (numeroDaConta:Int): Int? {

        for (i in 0 until listaDeContas.size){
            if (listaDeContas[i].numeroDaConta == numeroDaConta){
                listaDeContas[i].mostrarDados()
                return i
            }
        }

        println("Conta não encontrada")
        return null
    }

    fun encontrarIndex (numeroDaConta: Int): Int? {
        for (i in 0 until listaDeContas.size){
            if (listaDeContas[i].numeroDaConta == numeroDaConta){
                return i
            }
        }
        return null
    }

    override fun mostrarDados() {
        println("Lista de Contas")

        for (i in 0 until listaDeContas.size){
            println("------------------")
            listaDeContas[i].mostrarDados()
        }
    }

    fun sacar(numeroDaConta: Int, valor: Double) {
        var indexDaConta = encontrarIndex(numeroDaConta)

        if (indexDaConta == null) {
            println("Conta não encontrada")
            return
        } else {
            listaDeContas[indexDaConta].sacar(valor)
            return
        }
    }

    fun depositar (numeroDaConta: Int, valor:Double) {
        var indexDaConta = encontrarIndex(numeroDaConta)

        if (indexDaConta == null) {
            println("Conta não encontrada")
            return
        } else {
            listaDeContas[indexDaConta].depositar(valor)
            return
        }
    }

    fun transferir (contaOrigem: Int, valor: Double, contaDestino:Int) {

        var indexDaConta = encontrarIndex(contaOrigem)

        var indexDaContaDestino = procurarConta(contaDestino)

        if (indexDaConta == null || indexDaContaDestino == null) {
            println("Conta não encontrada")
            return
        } else {
            listaDeContas[indexDaConta].transferir(valor, listaDeContas[indexDaContaDestino])
            return
        }
    }

    fun relatorioDeConta (numeroDaConta: Int) {
        var indexDaConta = encontrarIndex(numeroDaConta)

        if (indexDaConta == null) {
            println("Conta não encontrada")
            return
        } else {
            listaDeContas[indexDaConta].mostrarDados()
            return
        }
    }
}
