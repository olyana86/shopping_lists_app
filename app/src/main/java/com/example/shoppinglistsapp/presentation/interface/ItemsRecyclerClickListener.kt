package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemEntity

interface ItemsRecyclerClickListener {

    fun onItemClicked(itemEntity: ItemEntity)

    fun onCheckItemClicked(itemEntity: ItemEntity)

    fun onDeleteItemClicked(itemEntity: ItemEntity)
}