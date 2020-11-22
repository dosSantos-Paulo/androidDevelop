package com.example.chuckspearl.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"

        fun getRetrofitInstance(baseUrl:String = BASE_URL): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}