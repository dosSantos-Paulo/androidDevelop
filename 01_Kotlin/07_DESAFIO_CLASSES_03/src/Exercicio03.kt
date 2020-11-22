fun main () {
    var atleta1 = Atleta()
    atleta1.nome = "Dayane dos Santos"
    atleta1.energia = 100
    atleta1.nivel = 8

    var atleta2 = Atleta()
    atleta2.nome = "João do Pulo"
    atleta2.energia = 70
    atleta2.nivel = 10

    var prova1 = Prova (6, 30)
    var prova2 = Prova (8, 50)
    var prova3 = Prova (9, 75)

    prova3.realizarProva(atleta1)

}