package com.example.webservice.api.model

import com.example.webservice.api.model.OriginModel
import com.google.gson.annotations.SerializedName

data class CharacterModel(
    val id: Int,
    @SerializedName("name")
    val nome: String,
    val status: String,
    @SerializedName("origin")
    val origem: OriginModel,
    @SerializedName("episodes")
    val episodeos: List<String>
)
