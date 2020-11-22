package com.example.chuckspearl.category.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.chuckspearl.category.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers

class CategoryViewModel(
    private val _repository: CategoryRepository
): ViewModel() {

    fun getCategories() = liveData(Dispatchers.IO) {
        val response = _repository.categories()
        emit(response)
    }

    class CategoryViewModelFactory(
        private val _repository: CategoryRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoryViewModel(_repository) as T
        }
    }

}