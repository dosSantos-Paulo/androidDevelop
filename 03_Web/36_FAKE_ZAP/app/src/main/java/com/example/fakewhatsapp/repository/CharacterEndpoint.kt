package com.example.fakewhatsapp.repository

import com.example.fakewhatsapp.model.CharacterModel
import com.example.fakewhatsapp.utils.NetworkUtils
import retrofit2.create
import retrofit2.http.GET

interface CharacterEndpoint {
    @GET("characters")
    suspend fun getList(): List<CharacterModel>

    companion object {
        val Endpoint: CharacterEndpoint by lazy {
            NetworkUtils.getRetrofit().create(CharacterEndpoint::class.java)
        }
    }
}