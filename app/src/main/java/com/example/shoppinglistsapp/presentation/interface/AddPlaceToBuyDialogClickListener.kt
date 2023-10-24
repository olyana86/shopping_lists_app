package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity

interface AddPlaceToBuyDialogClickListener {

    fun addPlaceToBuy(itemPlaceToBuyEntity: ItemPlaceToBuyEntity)
}