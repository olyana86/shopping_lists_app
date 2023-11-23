package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AutoListViewModel(val repository: ShoppingListsRepository) : ViewModel() {

    fun getItemsByCategoryId(categoryId: Long) = liveData {
        repository.getItemsByCategoryId(categoryId).collect {
            emit(it)
        }
    }

    fun getItemsByPriorityId(priorityId: Long) = liveData {
        repository.getItemsByPriorityId(priorityId).collect {
            emit(it)
        }
    }

    fun getItemsByPlaceToBuyId(placeToBuyId: Long) = liveData {
        repository.getItemsByPlaceToBuyId(placeToBuyId).collect {
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