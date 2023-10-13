package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.data.entity.ItemPriorityEntity

@Dao
interface ItemPriorityDao {
    @Insert
    fun insertAllPriorities(priorities: List<ItemPriorityEntity>)

    @Query("SELECT * FROM item_priority")
    fun getAllPriorities(): List<ItemPriorityEntity>

    @Query ("SELECT * FROM item_priority WHERE priority_id = :priorityId LIMIT 1")
    fun getPriorityById(priorityId: Long): ItemPriorityEntity
}