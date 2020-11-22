package com.example.chuckspearl.joke.repository

class JokeRepository {
    private val _client = JokeEndpoint.endpointJoke

    suspend fun joke(category: String) = _client.joke(category)
}