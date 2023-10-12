package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.ListWithItems
import com.example.shoppinglistsapp.data.entity.PlaceToBuyWithItems

@Dao
interface ListWithItemsDao {
    @Transaction
    @Query("SELECT * FROM list WHERE list_id = listId")
    fun getListWithItemsById(listId: Long): ListWithItems

    @Transaction
    @Query("SELECT * FROM list")
    fun getListsWithItems(): List<ListWithItems>
}