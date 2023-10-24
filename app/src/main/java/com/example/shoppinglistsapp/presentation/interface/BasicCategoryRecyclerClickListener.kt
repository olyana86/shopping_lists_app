package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity

interface BasicCategoryRecyclerClickListener {

    fun onItemClicked(itemCategoryEntity: ItemCategoryEntity)
}