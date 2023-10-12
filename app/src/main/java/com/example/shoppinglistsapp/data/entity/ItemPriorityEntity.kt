package com.example.shoppinglistsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_priority")
data class ItemPriorityEntity(

    @PrimaryKey
    var priority_id: Long,

    @ColumnInfo(name = "priority_name")
    var priorityName: String
)
