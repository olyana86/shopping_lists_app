package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    fun getNewList() = liveData {
        repository.getLastList().collect{
            emit(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}