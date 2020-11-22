fun main () {
    var cliente1 = Cliente ()
    cliente1.nome = "Paulo"
    cliente1.sobrenome = "Lima dos Santos"

    var conta1 = Conta(cliente1, 1234567890)
    conta1.saldo = 150.00

    var cliente2 = Cliente()
    cliente2.nome = "Felipe"
    cliente2.sobrenome = "Miranda"

    var conta2 = Conta(cliente2, 9876543210)
    conta2.saldo = 1000.00

    println("Este é o Deposito da conta 01 ${conta1.deposito(30.00)}")
    println(":::::::::::::::::::::::::::::::::::::::::::::::::")
    println("Este é o Deposito da conta 02 ${conta2.deposito(3000.00)}")
    println(":::::::::::::::::::::::::::::::::::::::::::::::::")
    println("Este é o saque da conta 01 ${conta1.saque(500.00)}")
    println(":::::::::::::::::::::::::::::::::::::::::::::::::")
    println("Este é o saque da conta 02 ${conta2.saque(500.00     )}")
    println(":::::::::::::::::::::::::::::::::::::::::::::::::")

}