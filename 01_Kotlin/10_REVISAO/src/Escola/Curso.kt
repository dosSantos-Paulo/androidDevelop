package Escola

class Curso (private val nome: String) {

    private val responsavel: Professor? = null
    val listaDeAulas get() = ArrayList<Aula>()
    val listaDeAlunos get() = ArrayList<Aluno>()
}