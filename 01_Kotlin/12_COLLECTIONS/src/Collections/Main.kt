package Collections

fun main () {
    val sp = Estado("SP", "São Paulo")
    val rj = Estado("RJ", "Rio de Janeiro")
    val sc = Estado("SC", "Santa Catarina")
    val rr = Estado("RR", "Roraima")

    var estados = listOf<Estado>(sp,rj,sc,rr)

    val pessoa1 = Pessoa("Paulo", sp)
    val pessoa2 = Pessoa("Bruno", rj)
    val pessoa3 = Pessoa("Maria", sc)
    val pessoa4 = Pessoa("José", sp)
    val pessoa5 = Pessoa("Cláudia", rr)
    val pessoa6 = Pessoa("Júlia", sc)

    var pessoas = listOf<Pessoa>(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6)

    val pessoasOrdenadas = mutableMapOf<Estado, MutableList<Pessoa>>()

    pessoas.forEach {
        if (!pessoasOrdenadas.containsKey(it.estado.sigla)){
            pessoasOrdenadas[it.estado] = mutableListOf()
        }
        pessoasOrdenadas[it.estado]?.add(it)

    }

    print(pessoasOrdenadas)

//    println(pessoas.groupBy{ it.estado.sigla})

}
