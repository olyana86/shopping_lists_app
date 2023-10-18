package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.data.entity.PlaceToBuyWithItems
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceToBuyWithItemsDao {
    @Transaction
    @Query("SELECT * FROM item WHERE item_place_to_buy_id = :placeToBuyId")
    fun getPlaceToBuyWithItemsById(placeToBuyId: Long): Flow<List<ItemEntity>>
}