package com.example.shoppinglistsapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PlaceToBuyWithItems(
    @Embedded var placeToBuy: ItemPlaceToBuyEntity,

    @Relation(
        parentColumn = "place_to_buy_id",
        entityColumn = "item_place_to_buy_id"
    )
    var items: List<ItemEntity>
)
