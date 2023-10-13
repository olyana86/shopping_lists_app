package com.example.shoppinglistsapp.data.repository

import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.data.entity.ListEntity

class ShoppingListsRepository (private val db: ShoppingListsDatabase) {

    suspend fun insertItem(item: ItemEntity) = db.itemDao().insertItem(item)
    suspend fun insertCategory(category: ItemCategoryEntity) = db.itemCategoryDao().insertCategory(category)
    suspend fun insertPlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().insertPlaceToBuy(placeToBuy)
    suspend fun insertList(list: ListEntity) = db.listDao().insertList(list)

    suspend fun deleteItem(item: ItemEntity) = db.itemDao().deleteItem(item)
    suspend fun deleteCategory(category: ItemCategoryEntity) = db.itemCategoryDao().deleteCategory(category)
    suspend fun deletePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().deletePlaceToBuy(placeToBuy)
    suspend fun deleteList(list: ListEntity) = db.listDao().deleteList(list)

    suspend fun updateItem(item: ItemEntity) = db.itemDao().updateItem(item)
    suspend fun updateCategory(category: ItemCategoryEntity) = db.itemCategoryDao().updateCategory(category)
    suspend fun updatePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().updatePlaceToBuy(placeToBuy)
    suspend fun updateList(list: ListEntity) = db.listDao().updateList(list)

    suspend fun getAllItems() = db.itemDao().getAllItems()
    suspend fun getAllCategories() = db.itemCategoryDao().getAllCategories()
    suspend fun getAllPriorities() = db.itemPriorityDao().getAllPriorities()
    suspend fun getAllPlacesToBuy() = db.itemPlaceToBuyDao().getAllPlacesToBuy()
    suspend fun getAllLists() = db.listDao().getAllLists()

    suspend fun getCategoryWithItemsById(categoryId: Long) = db.categoryWithItemsDao().getCategoryWithItemsById(categoryId)
    suspend fun getPriorityWithItemsById(priorityId: Long) = db.priorityWithItemsDao().getPriorityWithItemsById(priorityId)
    suspend fun getPlaceToBuyWithItemsById(placeToBuyId: Long) = db.placeToBuyWithItemsDao().getPlaceToBuyWithItemsById(placeToBuyId)
    suspend fun getListWithItemsById(listId: Long) = db.listWithItemsDao().getListWithItemsById(listId)

    suspend fun getItemById(itemId: Long) = db.itemDao().getItemById(itemId)
    suspend fun getCategoryById(categoryId: Long) = db.itemCategoryDao().getCategoryById(categoryId)
    suspend fun getPriorityById(priorityId: Long) = db.itemPriorityDao().getPriorityById(priorityId)
    suspend fun getPlaceToBuyById(placeToBuyId: Long) = db.itemPlaceToBuyDao().getPlaceToBuyById(placeToBuyId)
    suspend fun getListById(listId: Long) = db.listDao().getListById(listId)
}

