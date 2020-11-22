package com.example.chuckspearl.category.repository

import com.example.chuckspearl.utils.NetworkUtils
import retrofit2.http.GET

interface CategoryEndpoint {
    @GET("categories")
    suspend fun categories(): List<String>

    companion object {
        val endpoint: CategoryEndpoint by lazy {
            NetworkUtils.getRetrofitInstance()
                .create(CategoryEndpoint::class.java)
        }
    }
}