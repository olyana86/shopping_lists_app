package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemEntity

interface UpdateItemDialogClickListener {
    fun updateItem(itemEntity: ItemEntity)
}