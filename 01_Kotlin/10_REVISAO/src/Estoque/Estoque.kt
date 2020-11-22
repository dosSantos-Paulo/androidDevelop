package Estoque

class Estoque (var nome: String,
               var quantidadeAtual: Int,
               var quantidadeMinima: Int ) {

    init{
        quantidadeAtual = Math.max(0, quantidadeAtual)
        quantidadeMinima = Math.max(0, quantidadeMinima)
    }

    fun mudarNome (novoNome: String) {
        nome = novoNome
    }
    fun mudarQuantidadeMinima (novaQuantidade: Int) {
        if (quantidadeAtual + novaQuantidade < 0){
            throw Exception("Quantidade não pode ser negativa")
        }
        quantidadeMinima = novaQuantidade
    }

    fun repor(quantidade: Int) {
        quantidadeAtual += quantidade
    }

    fun darBaixa (quantidade: Int) {
        if (quantidadeAtual - quantidade < 0){
            throw Exception("Quantidade não pode ser negativa")
        }
        quantidadeAtual -= quantidade
    }

    fun mostrar (): String {
        return "Nome: $nome \n" +
                "Quantidade minima: $quantidadeMinima \n" +
                "Quantidade atual: $quantidadeAtual"
    }

    fun precisaRepor () = quantidadeAtual <= quantidadeMinima
}