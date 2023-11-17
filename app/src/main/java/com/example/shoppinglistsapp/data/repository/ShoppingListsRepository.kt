package com.example.shoppinglistsapp.data.repository

import androidx.room.Transaction
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.*
import kotlinx.coroutines.flow.Flow

class ShoppingListsRepository (private val db: ShoppingListsDatabase) {

    val allCategories = db.itemCategoryDao().getAllCategories()
    val allPlacesToBuy = db.itemPlaceToBuyDao().getAllPlacesToBuy()
    val allUserLists = db.listDao().getAllLists()

    fun getLastList(): Flow<ListEntity> {return db.listDao().getLastList()}

    fun getItemsByCategoryId(categoryId: Long): Flow<List<ItemEntity>> {return db.itemCategoryDao().getCategoryWithItemsById(categoryId)}
    fun getItemsByPriorityId(priorityId: Long): Flow<List<ItemEntity>> {return db.itemDao().getPriorityWithItemsById(priorityId)}
    fun getItemsByPlaceToBuyId(placeToBuyId: Long): Flow<List<ItemEntity>> {return db.itemPlaceToBuyDao().getPlaceToBuyWithItemsById(placeToBuyId)}
    fun getItemsByListId(listId: Long): Flow<List<ItemEntity>> {return db.itemDao().getItemsByListId(listId)}

    fun getSelectedCategories(isDeletable: Boolean): Flow<List<ItemCategoryEntity>> {return db.itemCategoryDao().getSelectedCategories(isDeletable)}

    suspend fun insertItem(item: ItemEntity) = db.itemDao().insertItem(item)
    suspend fun insertCategory(category: ItemCategoryEntity) = db.itemCategoryDao().insertCategory(category)
    suspend fun insertPlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().insertPlaceToBuy(placeToBuy)
    suspend fun insertList(listEntity: ListEntity) = db.listDao().insertList(listEntity)

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


