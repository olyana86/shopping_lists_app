package com.example.shoppinglistsapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PriorityWithItems(
    @Embedded var priority: ItemPriorityEntity,
    @Relation(
        parentColumn = "priority_id",
        entityColumn = "item_id"
    )
    var items: List<ItemEntity>
)

