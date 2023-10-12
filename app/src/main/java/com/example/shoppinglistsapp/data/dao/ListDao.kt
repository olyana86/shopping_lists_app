package com.example.shoppinglistsapp.data.dao

import androidx.room.*
import com.example.shoppinglistsapp.data.entity.ListEntity

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: ListEntity)

    @Update
    fun updateList(list: ListEntity)

    @Delete
    fun deleteList(list: ListEntity)

    @Query("SELECT * FROM list")
    fun getAllLists(): List<ListEntity>
}