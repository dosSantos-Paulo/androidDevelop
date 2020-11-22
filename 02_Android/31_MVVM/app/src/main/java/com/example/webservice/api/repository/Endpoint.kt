package com.example.webservice.api.repository

import com.example.webservice.api.model.ApiResponseModel
import com.example.webservice.api.model.CharacterModel
import com.example.webservice.api.model.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("character")
    fun obterPersonagens(): Call<ApiResponseModel<CharacterModel>>

    @GET("character/[id]")
    fun obterDetalhesPersonagem(@Path("id") id: Int): Call<CharacterModel>

    @GET("location")
    fun obterLocalizacao(): Call<ApiResponseModel<LocationModel>>

    @GET("location/[id]")
    fun obterDetalhesLocalizacao(@Path("id") id: Int): Call<LocationModel>
}