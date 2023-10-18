package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ItemPriorityEntity
import com.example.shoppinglistsapp.data.entity.ListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: ListEntity)

    @Update
    fun updateList(list: ListEntity)

    @Delete
    fun deleteList(list: ListEntity)

    @Query("SELECT * FROM list")
    fun getAllLists(): Flow<List<ListEntity>>

    @Query ("SELECT * FROM list WHERE list_id = :listId LIMIT 1")
    fun getListById(listId: Long): Flow<ListEntity>
}