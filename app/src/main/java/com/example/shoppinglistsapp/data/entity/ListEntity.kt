package com.example.shoppinglistsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list")
data class ListEntity(

    @PrimaryKey(autoGenerate = true)
    var list_id: Long? = null,

    @ColumnInfo(name = "list_name")
    var listName: String
)
