class Carro (var consumo:Int){
    var tanqueDeCombustivel = 0

    fun andar (distancia:Int) {
        if (distancia <= tanqueDeCombustivel * consumo){
            println("Andou $distancia Km")
        } else {
            println("Você não tem gasolina suficiente para isso!")
        }
        return
    }

    fun obterCombustivel () = println("Autonomia de: ${tanqueDeCombustivel * consumo} Km")

    fun adicionarGasolina (quantidade:Int) {
        println("Você abasteceu $quantidade L")
        tanqueDeCombustivel += quantidade
        obterCombustivel()
        return
    }
}