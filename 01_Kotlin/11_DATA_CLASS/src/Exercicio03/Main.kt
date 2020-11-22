package Exercicio03

fun main () {
    val aluno1 = Aluno("Paulo", 10)
    val aluno2 = Aluno("Maria", 9)
    val aluno3 = Aluno("Claudio", 8)
    val aluno4 = Aluno("Jose", 7)

    val aluno5 = Aluno("Rita", 10)

    val listaDeAlunos = ArrayList<Aluno>()

    listaDeAlunos.add(aluno1)
    listaDeAlunos.add(aluno2)
    listaDeAlunos.add(aluno3)
    listaDeAlunos.add(aluno4)

    println(listaDeAlunos.contains(aluno5))

}