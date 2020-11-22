package com.digitalhouse.rickapp.listapersonagem.model

import com.digitalhouse.rickapp.listapersonagem.model.Personagem
import com.google.gson.annotations.SerializedName

data class Resultado(
    @SerializedName("results")
    val resultados: List<Personagem>
)