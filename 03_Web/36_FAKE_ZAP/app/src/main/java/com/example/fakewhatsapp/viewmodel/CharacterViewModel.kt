package com.example.fakewhatsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.fakewhatsapp.model.CharacterModel
import com.example.fakewhatsapp.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel (
    private val _repository: CharacterRepository
): ViewModel() {

    private var _character: List<CharacterModel> = listOf()

    fun getList () = liveData(Dispatchers.IO) {
        val response = _repository.getList()
        _character = response

        emit(response)
    }

    class CharacterViewModelFactory (
        private val _repository: CharacterRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModelFactory(_repository) as T
        }

    }
}

