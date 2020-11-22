package Conditions

fun main () {

    var respostas = 0

    print("Telefonou para a vítima?(S/N): ")

    when (readLine()!!.toUpperCase()){
        "S"  -> respostas += 1
        "SIM" -> respostas += 1
    }

    print("Esteve no local do crime?(S/N): ")

    when (readLine()!!.toUpperCase()){
        "S"  -> respostas += 1
        "SIM" -> respostas += 1
    }

    print("Mora perto da vítima?(S/N): ")

    when (readLine()!!.toUpperCase()){
        "S"  -> respostas += 1
        "SIM" -> respostas += 1
    }

    print("Devia para a vítima?(S/N): ")

    when (readLine()!!.toUpperCase()){
        "S"  -> respostas += 1
        "SIM" -> respostas += 1
    }

    print("Já trabalhou para a vítima?(S/N): ")

    when (readLine()!!.toUpperCase()){
        "S"  -> respostas += 1
        "SIM" -> respostas += 1
    }

    when (respostas){
        5 -> print("Você é o Assassino")
        in 3..4 -> print("Você é Cúmplice")
        2 -> print("Você é suspeito")
        in 0..1 -> print("Você estava no lugar errado... vaza daqui!!!")
    }

  }