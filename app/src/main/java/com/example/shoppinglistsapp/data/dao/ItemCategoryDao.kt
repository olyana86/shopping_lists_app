package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

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
    fun getAllCategories(): Flow<List<ItemCategoryEntity>>

    @Query("SELECT * FROM item_category WHERE is_deletable = :isDeletable")
    fun getSelectedCategories(isDeletable: Boolean): Flow<List<ItemCategoryEntity>>

    @Query("SELECT * FROM item_category WHERE category_id = :categoryId LIMIT 1")
    fun getCategoryById(categoryId: Long): Flow<ItemCategoryEntity>

    @Query("SELECT * FROM item WHERE item_category_id = :categoryId")
    fun getCategoryWithItemsById(categoryId: Long): Flow<List<ItemEntity>>
}