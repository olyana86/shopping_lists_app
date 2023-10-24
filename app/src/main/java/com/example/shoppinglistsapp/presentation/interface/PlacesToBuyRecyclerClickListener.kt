package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity

interface PlacesToBuyRecyclerClickListener {

    fun onPlaceToBuyClicked(itemPlaceToBuyEntity: ItemPlaceToBuyEntity)

    fun onEditPlaceToBuyClicked(itemPlaceToBuyEntity: ItemPlaceToBuyEntity)

    fun onDeletePlaceToBuyClicked(itemPlaceToBuyEntity: ItemPlaceToBuyEntity)
}