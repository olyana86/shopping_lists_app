package com.example.shoppinglistsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_category")
data class ItemCategoryEntity(

    @PrimaryKey
    var category_id: Long,

    @ColumnInfo(name = "category_name")
    var categoryName: String,

    @ColumnInfo(name = "is_editable")
    var categoryIsEditable: Boolean,

    @ColumnInfo(name = "is_deletable")
    var categoryIsDeletable: Boolean
)
