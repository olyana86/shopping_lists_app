package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity

interface ItemPlaceToBuyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Update
    fun updatePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Delete
    fun deletePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Query("SELECT * FROM item_place_to_buy")
    fun getAllPlacesToBuy(): List<ItemPlaceToBuyEntity>

    @Query ("SELECT * FROM item_place_to_buy WHERE place_to_buy_id = :placeToBuyId LIMIT 1")
    fun getPlaceToBuyById(placeToBuyId: Long): ItemPlaceToBuyEntity
}