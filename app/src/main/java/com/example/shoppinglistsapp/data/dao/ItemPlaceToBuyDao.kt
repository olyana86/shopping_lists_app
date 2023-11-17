package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemPlaceToBuyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Update
    fun updatePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Delete
    fun deletePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity)

    @Query("SELECT * FROM item_place_to_buy")
    fun getAllPlacesToBuy(): Flow<List<ItemPlaceToBuyEntity>>

    @Query ("SELECT * FROM item_place_to_buy WHERE place_to_buy_id = :placeToBuyId LIMIT 1")
    fun getPlaceToBuyById(placeToBuyId: Long): Flow<ItemPlaceToBuyEntity>

    @Query("SELECT * FROM item WHERE item_place_to_buy_id = :placeToBuyId")
    fun getPlaceToBuyWithItemsById(placeToBuyId: Long): Flow<List<ItemEntity>>
}