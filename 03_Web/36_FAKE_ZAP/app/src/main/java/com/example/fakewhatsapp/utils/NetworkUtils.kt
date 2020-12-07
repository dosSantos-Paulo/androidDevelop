package com.example.fakewhatsapp.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {

        fun getRetrofit (baseUrl:String = BASE_URL) = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private const val BASE_URL = "https://www.breakingbadapi.com/api/"
    }

}