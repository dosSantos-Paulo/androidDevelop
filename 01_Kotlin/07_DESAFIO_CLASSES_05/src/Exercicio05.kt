fun main () {
    var cliente01 = Cliente("Paulo", "Leonardo", "(11) 95599-9955")

    var veiculo01 = Veiculo("VolksWagen", "Virtus")
    veiculo01.anoFabricacao = 2020
    veiculo01.cor = "Preto"

    Concecionaria().registrarVendas(cliente01,veiculo01,70000.00)



}