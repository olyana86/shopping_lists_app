package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: ListEntity): Long

    @Update
    fun updateList(list: ListEntity)

    @Query("DELETE FROM list WHERE list_id = :listId")
    fun deleteList(listId: Long)

    @Query("SELECT * FROM list")
    fun getAllLists(): Flow<List<ListEntity>>

    @Query ("SELECT * FROM list WHERE list_id = :listId LIMIT 1")
    fun getListById(listId: Long): Flow<ListEntity>
}