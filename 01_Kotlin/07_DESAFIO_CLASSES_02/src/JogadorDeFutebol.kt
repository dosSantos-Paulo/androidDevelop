class JogadorDeFutebol (var nome: String){
    var energia = 0
    var alegria = 0
    var gol = 0
    var experiencia = 0

    fun fazerGol () {
        energia -= 5
        alegria += 10
        gol++
        return println("GOOOOL!")
    }

    fun correr () {
        energia -= 10
        return println("Cansei")
    }


}