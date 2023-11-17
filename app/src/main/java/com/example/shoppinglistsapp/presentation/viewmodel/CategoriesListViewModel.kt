package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesListViewModel(private val repository: ShoppingListsRepository) : ViewModel() {

    fun getEditableCategories(isDeletable: Boolean) = liveData {
        repository.getSelectedCategories(isDeletable).collect {
            emit(it)
        }
    }

    fun addCategory(itemCategory: ItemCategoryEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCategory(itemCategory)
        }
    }

    fun deleteCategory(itemCategory: ItemCategoryEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCategory(itemCategory)
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