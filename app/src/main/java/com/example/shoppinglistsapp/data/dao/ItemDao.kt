package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemEntity

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: ItemEntity)

    @Update
    fun updateItem(item: ItemEntity)

    @Delete
    fun deleteItem(item: ItemEntity)

    @Query("SELECT * FROM item")
    fun getAllItems(): List<ItemEntity>

    @Query ("SELECT * FROM item WHERE item_id = :itemId LIMIT 1")
    fun getItemById(itemId: Long): ItemEntity
}