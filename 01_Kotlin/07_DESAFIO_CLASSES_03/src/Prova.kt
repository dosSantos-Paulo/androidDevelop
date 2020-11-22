class Prova (var dificuldade: Int, var energiaNecessaria: Int){

    fun realizarProva (atleta: Atleta) {
        if (atleta.nivel >= dificuldade && atleta.energia >= energiaNecessaria) {
            println("${atleta.nome} pode realizar a prova")
            println("${atleta.nome} tem ${atleta.energia} pontos de energia")
            println("::: Realizando prova :::")
            println(":::")
            println(":::")
            println(":::")

            atleta.energia -= energiaNecessaria

            println("${atleta.nome} agora tem ${atleta.energia} pontos de energia")

        } else {
            println("::: ${atleta.nome} não pode realizar a prova :::")
        }
    }
}