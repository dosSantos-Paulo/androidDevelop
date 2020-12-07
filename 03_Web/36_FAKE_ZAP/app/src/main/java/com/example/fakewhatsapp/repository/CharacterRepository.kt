package com.example.fakewhatsapp.repository

class CharacterRepository {
    private val _client = CharacterEndpoint.Endpoint
    suspend fun getList() = _client.getList()
}