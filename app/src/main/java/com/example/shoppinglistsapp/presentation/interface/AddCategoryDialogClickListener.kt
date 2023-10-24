package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity

interface AddCategoryDialogClickListener {
    fun addCategory(itemCategoryEntity: ItemCategoryEntity)
}