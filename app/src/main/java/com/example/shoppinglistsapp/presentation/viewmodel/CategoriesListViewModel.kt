package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository

class CategoriesListViewModel(private val repository: ShoppingListsRepository) : ViewModel() {

    fun getAllCategories() = liveData {
        repository.allCategories.collect {
            emit(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}