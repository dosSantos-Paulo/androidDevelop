package com.example.chuckspearl.joke.repository

import com.example.chuckspearl.joke.model.JokeModel
import com.example.chuckspearl.utils.NetworkUtils
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeEndpoint {
    @GET("random")
    suspend fun joke(@Query("category") category: String): JokeModel

    companion object {
        val endpointJoke: JokeEndpoint by lazy {
            NetworkUtils.getRetrofitInstance()
                .create(JokeEndpoint::class.java)
        }
    }
}