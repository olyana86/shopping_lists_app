package com.example.shoppinglistsapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistsapp.data.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryWithItemsDao {

    @Transaction
    @Query("SELECT * FROM item WHERE item_category_id = :categoryId")
    fun getCategoryWithItemsById(categoryId: Long): Flow<List<ItemEntity>>
}