class SessaoDeTreinamento (jogador: JogadorDeFutebol) {

    var experienciaDeTreino = 1

    fun treinarA (jogador: JogadorDeFutebol) {
        println("Experiência do jogador ${jogador.nome}, ANTES do treino:::")
        println("Experiência: ${jogador.experiencia}")
        println("Alegria: ${jogador.alegria}")
        println("Gols: ${jogador.gol}")
        println("::::::")
        println("::::::")
        println("::: Treino :::")

        jogador.correr()
        jogador.fazerGol()
        jogador.correr()
        jogador.experiencia += experienciaDeTreino

        println("::::::")
        println("::::::")
        println("::::::")

        println("Experiência do jogador ${jogador.nome}, DEPOIS do treino::: ${jogador.experiencia}")
        println("Experiência: ${jogador.experiencia}")
        println("Alegria: ${jogador.alegria}")
        println("Gols: ${jogador.gol}")
    }



}