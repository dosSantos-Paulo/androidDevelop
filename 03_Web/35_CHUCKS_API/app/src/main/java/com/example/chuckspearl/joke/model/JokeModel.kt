package com.example.chuckspearl.joke.model

import com.google.gson.annotations.SerializedName

data class JokeModel (
    @SerializedName("icon_url")
    val icon: String,
    val value: String
)