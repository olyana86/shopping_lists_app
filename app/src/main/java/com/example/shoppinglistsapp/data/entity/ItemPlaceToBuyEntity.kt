package com.example.shoppinglistsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_place_to_buy")
data class ItemPlaceToBuyEntity(

    @PrimaryKey(autoGenerate = true)
    var place_to_buy_id: Long? = null,

    @ColumnInfo(name = "place_to_buy_name")
    var placeToBuyName: String,

    @ColumnInfo(name = "place_to_buy_address")
    var placeToBuyAddress: String
)
