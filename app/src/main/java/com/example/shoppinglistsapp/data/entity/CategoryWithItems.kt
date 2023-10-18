package com.example.shoppinglistsapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithItems(
    @Embedded var category: ItemCategoryEntity,

    @Relation(
        parentColumn = "category_id",
        entityColumn = "item_category_id"
    )
    var items: List<ItemEntity>
)
