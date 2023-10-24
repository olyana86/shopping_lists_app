package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesListViewModel(private val repository: ShoppingListsRepository) : ViewModel() {

    fun getBasicCategories() = liveData {
        repository.basicCategories.collect {
            emit(it)
        }
    }

    fun getEditableCategories() = liveData {
        repository.editableCategories.collect {
            emit(it)
        }
    }

    fun deleteCategory(itemCategory: ItemCategoryEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCategory(itemCategory)
        }
    }

    fun addCategory(itemCategory: ItemCategoryEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCategory(itemCategory)
        }
    }

    fun updateCategory(itemCategory: ItemCategoryEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCategory(itemCategory)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}