package com.example.shoppinglistsapp.data.entity

import androidx.room.*
import androidx.room.ForeignKey.Companion.CASCADE

@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    var item_id: Long? = null,

    @ColumnInfo(name = "item_name")
    var itemName: String,

    @ColumnInfo(name = "item_quantity")
    var itemQuantity: String = "1 шт.",

    @ColumnInfo(name = "item_price")
    var itemPrice: Int = 0,

    @ColumnInfo(name = "item_priority_id")
    var itemPriorityId: Long = 2,

    @ColumnInfo(name = "item_category_id")
    var itemCategoryId: Long? = null,

    @ColumnInfo(name = "item_place_to_buy_id")
    var itemPlaceToBuyId: Long? = null,

    @ColumnInfo(name = "item_list_id")
    var itemListId: Long,

    @ColumnInfo(name = "item_is_bought")
    var itemIsBought: Boolean = false
)
