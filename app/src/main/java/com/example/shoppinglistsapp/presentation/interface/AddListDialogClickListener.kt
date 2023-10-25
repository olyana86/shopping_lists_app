package com.example.shoppinglistsapp.presentation.`interface`

import com.example.shoppinglistsapp.data.entity.ListEntity

interface AddListDialogClickListener {
    fun addList(listEntity: ListEntity)
}