package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity

interface EditableCategoryRecyclerClickListener {

    fun onItemClicked(itemCategoryEntity: ItemCategoryEntity)

    fun onEditItemClicked(itemCategoryEntity: ItemCategoryEntity)

    fun onDeleteItemClicked(itemCategoryEntity: ItemCategoryEntity)
}