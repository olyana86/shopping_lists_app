package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityViewModel(private val repository: ShoppingListsRepository) : ViewModel() {

    fun getUserLists() = liveData {
        repository.allUserLists.collect {
            emit(it)
        }
    }

    fun addNewList(listEntity: ListEntity) {
       viewModelScope.launch(Dispatchers.IO) {
           repository.insertList(listEntity)
       }
    }

    fun getEditableCategories(isDeletable: Boolean) = liveData {
        repository.getSelectedCategories(isDeletable).collect {
            emit(it)
        }
    }
}