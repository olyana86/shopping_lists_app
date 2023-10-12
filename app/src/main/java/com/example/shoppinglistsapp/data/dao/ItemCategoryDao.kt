package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity

@Dao
interface ItemCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: ItemCategoryEntity)

    @Insert
    fun insertAllCategories(categories: List<ItemCategoryEntity>)

    @Update
    fun updateList(category: ItemCategoryEntity)

    @Delete
    fun deleteList(category: ItemCategoryEntity)

    @Query("SELECT * FROM category")
    fun getAllCategories(): List<ItemCategoryEntity>
}