package com.example.chuckspearl.joke.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.chuckspearl.joke.repository.JokeRepository
import kotlinx.coroutines.Dispatchers

class JokeViewModel (
    private val _repository: JokeRepository
):ViewModel(){
    fun getNewJoke(category:String) = liveData (Dispatchers.IO) {
        val result = _repository.joke(category)

        emit(result)
    }

    class JokeViewModelFactory(
        private val _repository: JokeRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return JokeViewModel(_repository) as T
        }

    }
}