package Fatura

fun main () {
    val fatura = Fatura()

//    var item1 = Item(1, "Maças", 2, - 1.0)
//    var item2 = Item(2, "Laranja", -5, 2.5 )

    var item1 = Item(1, "Maças", 2,  1.0)
    var item2 = Item(2, "Laranja", 5, 2.5 )

    fatura.listaDeItem.add(item1)
    fatura.listaDeItem.add(item2)

    print(fatura.getTotalFatura())
}