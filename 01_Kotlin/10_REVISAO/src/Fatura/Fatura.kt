package Fatura

class Fatura(){

    var listaDeItem = ArrayList<Item>()

    fun getTotalFatura (): Double{
        var total = 0.0
        listaDeItem.forEach(){
            total += it.quantidade * it.precoUnitario
        }
        return total
    }
}