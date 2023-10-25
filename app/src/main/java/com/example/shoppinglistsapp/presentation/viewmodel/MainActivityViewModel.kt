package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

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

    fun addNewList(listEntity: ListEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertList(listEntity)
        }
    }
    fun getNewListId() = repository.newListId


    override fun onCleared() {
        super.onCleared()
    }
}