package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.*
import com.example.shoppinglistsapp.data.entity.ItemEntity
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

    fun deleteList(listId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteListById(listId)
        }
    }

    fun deleteItemsByListId(listId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItemsByListId(listId)
        }
    }

    fun getItemsByListId(listId: Long) = liveData {
        repository.getItemsByListId(listId).collect{
            emit(it)
        }
    }

    fun deleteItem(itemEntity: ItemEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(itemEntity)
        }
    }

    fun updateItem(itemEntity: ItemEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItem(itemEntity)
        }
    }

    fun addItem(itemEntity: ItemEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertItem(itemEntity)
        }
    }
    override fun onCleared() {
        super.onCleared()
    }
}