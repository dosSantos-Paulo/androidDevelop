class Conta (var titular: Cliente, var numeroDaConta:Long) {
    var saldo = 0.00

    fun deposito (valor:Double):Double {
        saldo += valor
        println(":: Olá, ${titular.nome} ::")
        println("+ Deposito: $valor")
        println("= Saldo: $saldo")
        return saldo
    }

    fun saque (valor:Double):Double{
        if (saldo <= valor) {
            println(":: Olá, ${titular.nome} ::")
            println("Saldo insuficiente")
        }else {
            saldo -= valor
            println(":: Olá, ${titular.nome} ::")
            println("Saque efetuado!")
            println("= Saldo: $saldo")
        }
        return saldo
    }

}