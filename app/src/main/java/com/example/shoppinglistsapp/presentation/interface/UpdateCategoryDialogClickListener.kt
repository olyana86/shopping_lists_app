package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity

interface UpdateCategoryDialogClickListener {
    fun updateCategory(itemCategoryEntity: ItemCategoryEntity)
}