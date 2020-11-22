fun main () {
    var banco = Banco()
    println("--- BANCO DIGITAL HOUSE ---")

    do {
        println()
        println("1 - Cadastrar conta")
        println("2 - Pesquisar conta")
        println("3 - Remover conta")
        println("4 - Gerar relatório")
        println("5 - Acessar Conta")
        println("0 - Sair")
        println()

        var respostaDoMenuBanco = readLine()!!.toInt()

        when (respostaDoMenuBanco) {
            1 -> menu1 (banco)
            2 -> menu2(banco)
            3 -> menu3(banco)
            4 -> banco.mostrarDados()
            5 -> menu5(banco)
            0 -> break
            else -> println("Reposta inválida")
        }
    } while (true)
}

fun menu1 (banco: Banco) {
    do {
        println()
        println("Qual tipo de conta gostaria de registrar ?")
        println("1 - Poupança")
        println("2 - Corrente")
        println("0 - Sair")
        println()

        var respostaDoCadastro = readLine()!!.toInt()

        if (respostaDoCadastro == 1){
            print("Digite o nª conta poupança: ")
            var numeroDaContaPoupanca = readLine()!!.toInt()
            print("Digite o limite: ")
            var limiteDaContaPoupança = readLine()!!.toDouble()
            var saldoInicial = 0.0

            banco.inserir(ContaPoupanca(numeroDaContaPoupanca, saldoInicial, limiteDaContaPoupança))

            println("Conta inserida com sucesso")

        } else if (respostaDoCadastro == 2){
            print("Digite o nª conta corrente: ")
            var numeroDaContaCorrente = readLine()!!.toInt()
            print("Digite a taxa de operação: ")
            var taxaDeOperacao = readLine()!!.toDouble()
            var saldoInicial = 0.0

            banco.inserir(ContaCorrente(numeroDaContaCorrente, saldoInicial, taxaDeOperacao))

            println("Conta inserida com sucesso")

        } else if (respostaDoCadastro == 0) break
          else println("Número inválido")

    } while (true)
}

fun menu2 (banco: Banco) {
    do {
        println()
        println("Digite o nª da conta que deseja pesquisar")
        println("ou \"0\" para voltar")
        print("Nª da Conta: ")

        var numeroDaConta = readLine()!!.toInt()

        println()
        when {
            (numeroDaConta > 0) -> banco.procurarConta(numeroDaConta)
            (numeroDaConta == 0) -> break
            else -> println("Entrada inválida, use os numerais do teclado")
        }
    } while (true)
}

fun menu3 (banco: Banco) {
    do {
        println("")
        println("Qual conta gostaria de remover?: ")
        println("1 - Poupança")
        println("2 - Corrente")
        println("0 - Sair")
        println("")

        var respostaMenuRemover = readLine()!!.toInt()

        when (respostaMenuRemover) {
            1 -> {
                print("Nª da Conta: ")
                var numeroDaContaParaRemover = readLine()!!.toInt()
                print("Saldo da Conta: ")
                var saldoDaContaParaRemover = readLine()!!.toDouble()
                print("Limite: ")
                var limiteDaContaParaRemover = readLine()!!.toDouble()

                banco.remover(ContaPoupanca(numeroDaContaParaRemover,
                        saldoDaContaParaRemover,
                        limiteDaContaParaRemover))
                break
            }
            2 -> {
                print("Nª da Conta: ")
                var numeroDaContaParaRemover = readLine()!!.toInt()
                print("Saldo da Conta: ")
                var saldoDaContaParaRemover = readLine()!!.toDouble()
                print("Taxa de operação: ")
                var taxaDaContaParaRemover = readLine()!!.toDouble()

                banco.remover(ContaPoupanca(numeroDaContaParaRemover,
                        saldoDaContaParaRemover,
                        taxaDaContaParaRemover))
                break
            }
            0 -> break
            else -> println("Conta não removida")
        }
    } while (true)
}

fun menu5 (banco: Banco) {
    do {
        println()
        println("Digite o Nº da conta para acessar")
        println("Ou \"0\" para voltar")
        print("Nº da Conta: ")
        println()

        var numeroDaContaParaAcessar = readLine()!!.toInt()

        when {
            (numeroDaContaParaAcessar > 0) -> {
                if (banco.procurarConta(numeroDaContaParaAcessar) == null) {
                    println("Conta inexistente")
                    continue
                } else {

                    do {

                        println()
                        println("Conta nº: $numeroDaContaParaAcessar")
                        println("1 - Sacar")
                        println("2 - Depositar")
                        println("3 - Transferir")
                        println("4 - Relatório")
                        println("0 - Sair")
                        println()

                        var respostaMenuConta = readLine()!!.toInt()

                        when (respostaMenuConta) {
                            1 -> {
                                print("Valor do saque: ")
                                var valorDoSaque = readLine()!!.toDouble()
                                banco.sacar(numeroDaContaParaAcessar,valorDoSaque)
                            }
                            2 -> {
                                print("Valor do depósito: ")
                                var valorDoDeposito = readLine()!!.toDouble()
                                banco.depositar(numeroDaContaParaAcessar,valorDoDeposito)
                            }
                            3 -> {
                                print("Digite o número da conta para transferir: ")
                                var contaParaTransferencia = readLine()!!.toInt()
                                print("Qual valor: ")
                                var valorDaTransferencia = readLine()!!.toDouble()

                                banco.transferir(numeroDaContaParaAcessar,
                                        valorDaTransferencia,
                                        contaParaTransferencia)
                            }
                            4 -> {
                                banco.relatorioDeConta(numeroDaContaParaAcessar)
                            }
                            0 -> break
                            else -> println("Entrada inválida")
                        }
                    } while (true)
                }
            }
            (numeroDaContaParaAcessar == 0) -> break
            else -> println("Entrada inválida")
        }
    } while (true)
}