package com.example.shoppinglistsapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ListWithItems(
    @Embedded var list: ListEntity,

    @Relation(
        parentColumn = "list_id",
        entityColumn = "item_list_id"
    )
    var items: List<ItemEntity>
)
