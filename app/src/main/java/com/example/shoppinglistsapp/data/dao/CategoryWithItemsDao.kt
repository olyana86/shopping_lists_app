package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.CategoryWithItems

@Dao
interface CategoryWithItemsDao {

    @Transaction
    @Query("SELECT * FROM item_category WHERE category_id = categoryId")
    fun getCategoryWithItemsById(categoryId: Long): CategoryWithItems

    @Transaction
    @Query("SELECT * FROM item_category")
    fun getCategoriesWithItems(): List<CategoryWithItems>
}