package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SingleUserListViewModel(val repository: ShoppingListsRepository) : ViewModel() {

    fun updateListTitle(listEntity: ListEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateList(listEntity)
        }
    }

    fun deleteList(listEntity: ListEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteList(listEntity)
        }
    }

    fun getItemsByListId(listId: Long) = liveData {
        repository.getItemsByListId(listId).collect{
            emit(it)
        }
    }
}