package Exercicio04

fun main () {
    var funcionario1 = Funcionario("Newton", 555)
    var funcionario2 = Funcionario("Turin", 256)
    var funcionario3 = Funcionario("Darwin", 1813)
    var funcionario4 = Funcionario("João", 1991)

    var funcionario5 = Funcionario("João", 1991)

    val listaDeFuncionario = ArrayList<Funcionario>()

    listaDeFuncionario.add(funcionario1)
    listaDeFuncionario.add(funcionario2)
    listaDeFuncionario.add(funcionario3)
    listaDeFuncionario.add(funcionario4)

    print(listaDeFuncionario.contains(funcionario5))



}