class Concecionaria (){
    var registroDeVendas = ArrayList<Venda>()

    fun registrarVendas (cliente: Cliente, veiculo: Veiculo, valor: Double) {
        registroDeVendas.add(Venda(cliente, veiculo, valor))



    }



}