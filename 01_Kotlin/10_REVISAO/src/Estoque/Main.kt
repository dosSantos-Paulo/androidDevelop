package Estoque

fun main () {
    var itemEstoque1 = Estoque ("Pringles", 100, 10)

    println(itemEstoque1.mostrar())
    itemEstoque1.darBaixa(95)
    println(itemEstoque1.mostrar())
    itemEstoque1.precisaRepor()

    itemEstoque1.mudarNome("Batata")
    itemEstoque1.repor(50)


    println(itemEstoque1.mostrar())
}