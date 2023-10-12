package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemEntity

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: ItemEntity)

    @Insert
    fun insertAllItems(items: List<ItemEntity>)

    @Update
    fun updateItem(item: ItemEntity)

    @Delete
    fun deleteItem(item: ItemEntity)

    @Query("SELECT * FROM item")
    fun getAllItems(): List<ItemEntity>
}