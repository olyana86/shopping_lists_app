package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ItemEntity

@Dao
interface ItemCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: ItemCategoryEntity)

    @Insert
    fun insertAllCategories(categories: List<ItemCategoryEntity>)

    @Update
    fun updateCategory(category: ItemCategoryEntity)

    @Delete
    fun deleteCategory(category: ItemCategoryEntity)

    @Query("SELECT * FROM item_category")
    fun getAllCategories(): List<ItemCategoryEntity>

    @Query ("SELECT * FROM item_category WHERE category_id = :categoryId LIMIT 1")
    fun getCategoryById(categoryId: Long): ItemCategoryEntity
}