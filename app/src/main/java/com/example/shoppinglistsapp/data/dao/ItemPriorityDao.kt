package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemPriorityEntity

@Dao
interface ItemPriorityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriority(priority: ItemPriorityEntity)

    @Insert
    fun insertAllPriorities(priorities: List<ItemPriorityEntity>)

    @Update
    fun updatePriority(priority: ItemPriorityEntity)

    @Delete
    fun deletePriority(priority: ItemPriorityEntity)

    @Query("SELECT * FROM priority")
    fun getAllPriorities(): List<ItemPriorityEntity>
}