package com.example.shoppinglistsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlacesToBuyListViewModel(val repository: ShoppingListsRepository) : ViewModel() {

    fun getPlacesToBuy() = liveData {
        repository.allPlacesToBuy.collect {
            emit(it)
        }
    }

    fun addPlaceToBuy(placeToBuyEntity: ItemPlaceToBuyEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPlaceToBuy(placeToBuyEntity)
        }
    }

    fun deletePlaceToBuy(placeToBuyEntity: ItemPlaceToBuyEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePlaceToBuy(placeToBuyEntity)
        }
    }

    fun updatePlaceToBuy(placeToBuyEntity: ItemPlaceToBuyEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePlaceToBuy(placeToBuyEntity)
        }
    }


    override fun onCleared() {
        super.onCleared()
    }
}