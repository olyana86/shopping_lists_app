package com.example.shoppinglistsapp.data.repository

import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.*
import kotlinx.coroutines.flow.Flow

class ShoppingListsRepository (private val db: ShoppingListsDatabase) {

    val allItems = db.itemDao().getAllItems()
    val allCategories = db.itemCategoryDao().getAllCategories()
    val basicCategories = db.itemCategoryDao().getBasicCategories()
    val editableCategories = db.itemCategoryDao().getEditableCategories()
    val allPriorities = db.itemPriorityDao().getAllPriorities()
    val allPlacesToBuy = db.itemPlaceToBuyDao().getAllPlacesToBuy()
    val allUserLists = db.listDao().getAllLists()

    var newListId: Long? = null

    fun getItemById(itemId: Long): Flow<ItemEntity> {return db.itemDao().getItemById(itemId)}
    fun getCategoryById(categoryId: Long): Flow<ItemCategoryEntity> {return db.itemCategoryDao().getCategoryById(categoryId)}
    fun getPriorityById(priorityId: Long): Flow<ItemPriorityEntity> {return db.itemPriorityDao().getPriorityById(priorityId)}
    fun getPlaceToBuyById(placeToBuyId: Long): Flow<ItemPlaceToBuyEntity> {return db.itemPlaceToBuyDao().getPlaceToBuyById(placeToBuyId)}
    fun getListById(listId: Long): Flow<ListEntity> {return db.listDao().getListById(listId)}

    fun getItemsByCategoryId(categoryId: Long): Flow<List<ItemEntity>> {return db.itemCategoryDao().getCategoryWithItemsById(categoryId)}
    fun getItemsByPriorityId(priorityId: Long): Flow<List<ItemEntity>> {return db.itemPriorityDao().getPriorityWithItemsById(priorityId)}
    fun getItemsByPlaceToBuyId(placeToBuyId: Long): Flow<List<ItemEntity>> {return db.itemPlaceToBuyDao().getPlaceToBuyWithItemsById(placeToBuyId)}
    fun getItemsByListId(listId: Long): Flow<List<ItemEntity>> {return db.itemDao().getItemsByListId(listId)}

    suspend fun insertItem(item: ItemEntity) = db.itemDao().insertItem(item)
    suspend fun insertCategory(category: ItemCategoryEntity) = db.itemCategoryDao().insertCategory(category)
    suspend fun insertPlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().insertPlaceToBuy(placeToBuy)
    suspend fun insertList(list: ListEntity){
        newListId = db.listDao().insertList(list)
    }

    suspend fun deleteItem(item: ItemEntity) = db.itemDao().deleteItem(item)
    suspend fun deleteCategory(category: ItemCategoryEntity) = db.itemCategoryDao().deleteCategory(category)
    suspend fun deletePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().deletePlaceToBuy(placeToBuy)
    suspend fun deleteListById(listId: Long) = db.listDao().deleteList(listId)
    suspend fun deleteItemsByListId(listId: Long) = db.itemDao().deleteItemsByListId(listId)

    suspend fun updateItem(item: ItemEntity) = db.itemDao().updateItem(item)
    suspend fun updateCategory(category: ItemCategoryEntity) = db.itemCategoryDao().updateCategory(category)
    suspend fun updatePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().updatePlaceToBuy(placeToBuy)
    suspend fun updateList(list: ListEntity) = db.listDao().updateList(list)
}


