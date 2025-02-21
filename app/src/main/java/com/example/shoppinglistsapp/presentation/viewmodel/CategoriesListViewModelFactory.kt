package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository

@Suppress("UNCHECKED_CAST")
class CategoriesListViewModelFactory(private val repository: ShoppingListsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoriesListViewModel(repository) as T
    }
}