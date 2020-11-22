fun main () {
    var jogador1 = JogadorDeFutebol ("Pelé")
    jogador1.alegria = 100
    jogador1.experiencia = 80
    jogador1.energia = 100

    var jogador2 = JogadorDeFutebol ("Maradona")
    jogador2.alegria = 50
    jogador2. experiencia = 70
    jogador2.energia = 80

    SessaoDeTreinamento(jogador1).treinarA(jogador1)
}