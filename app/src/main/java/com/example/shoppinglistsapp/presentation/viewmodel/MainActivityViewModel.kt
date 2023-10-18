package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel(private val repository: ShoppingListsRepository) : ViewModel() {

    fun getUserLists() = liveData {
        repository.allUserLists.collect {
            emit(it)
        }
    }

    fun getAllCategories() = liveData {
        repository.allCategories.collect {
            emit(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}