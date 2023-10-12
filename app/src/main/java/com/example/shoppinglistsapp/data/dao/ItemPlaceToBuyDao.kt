package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity

interface ItemPlaceToBuyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Insert
    fun insertAllPlacesToBuy(placesToBuy: List<ItemPlaceToBuyEntity>)

    @Update
    fun updatePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Delete
    fun deletePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Query("SELECT * FROM item_place_to_buy")
    fun getAllPlacesToBuy(): List<ItemPlaceToBuyEntity>
}