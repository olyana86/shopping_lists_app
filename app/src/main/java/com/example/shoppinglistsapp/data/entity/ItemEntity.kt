package com.example.shoppinglistsapp.data.entity

import androidx.room.*

@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    var item_id: Long,

    @ColumnInfo(name = "item_name")
    var itemName: String,

    @ColumnInfo(name = "item_quantity")
    var itemQuantity: String,

    @ColumnInfo(name = "item_price")
    var itemPrice: Double,

    @Embedded
    var itemPriority: ItemPriorityEntity,

    @Embedded
    var itemCategory: ItemCategoryEntity,

    @Embedded
    var itemPlaceToBuy: ItemPlaceToBuyEntity,

    @Embedded
    var itemList: ListEntity,

    @ColumnInfo(name = "item_is_bought")
    var itemIsBought: Boolean
)
