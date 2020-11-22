package com.example.chuckspearl.category.repository

class CategoryRepository {
    private val _client = CategoryEndpoint.endpoint

    suspend fun categories() = _client.categories()
}