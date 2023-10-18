package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ListWithItemsDao {
    @Transaction
    @Query("SELECT * FROM item WHERE item_list_id = :listId")
    fun getListWithItemsById(listId: Long): Flow<List<ItemEntity>>
}