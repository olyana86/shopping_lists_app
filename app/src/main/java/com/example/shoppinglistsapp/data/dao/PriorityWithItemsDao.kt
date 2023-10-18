package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PriorityWithItemsDao {
    @Transaction
    @Query("SELECT * FROM item WHERE item_priority_id = :priorityId")
    fun getPriorityWithItemsById(priorityId: Long): Flow<List<ItemEntity>>
}