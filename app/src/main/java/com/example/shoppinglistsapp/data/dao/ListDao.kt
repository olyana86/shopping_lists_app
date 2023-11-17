package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(list: ListEntity)

    @Update
    fun updateList(list: ListEntity)

    @Query("DELETE FROM list WHERE list_id = :listId")
    fun deleteList(listId: Long)

    @Query("SELECT * FROM list")
    fun getAllLists(): Flow<List<ListEntity>>

    @Query ("SELECT * FROM list WHERE list_id = :listId LIMIT 1")
    fun getListById(listId: Long): Flow<ListEntity>

    @Query("SELECT * FROM list ORDER BY list_id DESC LIMIT 1")
    fun getLastList(): Flow<ListEntity>
}