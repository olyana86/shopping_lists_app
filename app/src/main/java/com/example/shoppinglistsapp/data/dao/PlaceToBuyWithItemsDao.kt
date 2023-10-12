package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.PlaceToBuyWithItems

@Dao
interface PlaceToBuyWithItemsDao {
    @Transaction
    @Query("SELECT * FROM item_place_to_buy WHERE place_to_buy_id = placeToBuyId")
    fun getPlaceToBuyWithItemsById(placeToBuyId: Long): PlaceToBuyWithItems

    @Transaction
    @Query("SELECT * FROM item_place_to_buy")
    fun getPlacesToBuyWithItems(): List<PlaceToBuyWithItems>
}