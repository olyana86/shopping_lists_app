package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.data.entity.ItemPriorityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemPriorityDao {
    @Insert
    fun insertAllPriorities(priorities: List<ItemPriorityEntity>)

    @Query("SELECT * FROM item_priority")
    fun getAllPriorities(): Flow<List<ItemPriorityEntity>>

    @Query ("SELECT * FROM item_priority WHERE priority_id = :priorityId LIMIT 1")
    fun getPriorityById(priorityId: Long): Flow<ItemPriorityEntity>

    @Transaction
    @Query("SELECT * FROM item WHERE item_priority_id = :priorityId")
    fun getPriorityWithItemsById(priorityId: Long): Flow<List<ItemEntity>>
}