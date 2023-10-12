package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.PriorityWithItems

@Dao
interface PriorityWithItemsDao {
    @Transaction
    @Query("SELECT * FROM item_priority WHERE priority_id = priorityId")
    fun getPriorityWithItemsById(priorityId: Long): PriorityWithItems

    @Transaction
    @Query("SELECT * FROM item_priority")
    fun getPrioritiesWithItems(): List<PriorityWithItems>
}