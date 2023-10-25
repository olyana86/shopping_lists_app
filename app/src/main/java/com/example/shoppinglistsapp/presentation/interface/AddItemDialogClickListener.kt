package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemEntity

interface AddItemDialogClickListener {
    fun addItem(itemEntity: ItemEntity)
}