package com.example.shoppinglistsapp.data.repository

import androidx.room.Transaction
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.*
import kotlinx.coroutines.flow.Flow

class ShoppingListsRepository (private val db: ShoppingListsDatabase) {

    val allCategories = db.itemCategoryDao().getAllCategories()
    val allPlacesToBuy = db.itemPlaceToBuyDao().getAllPlacesToBuy()
    val allUserLists = db.listDao().getAllLists()

    fun getItemsByCategoryId(categoryId: Long): Flow<List<ItemEntity>> {return db.itemCategoryDao().getCategoryWithItemsById(categoryId)}
    fun getItemsByPriorityId(priorityId: Long): Flow<List<ItemEntity>> {return db.itemDao().getPriorityWithItemsById(priorityId)}
    fun getItemsByPlaceToBuyId(placeToBuyId: Long): Flow<List<ItemEntity>> {return db.itemPlaceToBuyDao().getPlaceToBuyWithItemsById(placeToBuyId)}
    fun getItemsByListId(listId: Long): Flow<List<ItemEntity>> {return db.itemDao().getItemsByListId(listId)}

    fun getSelectedCategories(isDeletable: Boolean): Flow<List<ItemCategoryEntity>> {return db.itemCategoryDao().getSelectedCategories(isDeletable)}

     fun insertItem(item: ItemEntity) = db.itemDao().insertItem(item)
     fun insertCategory(category: ItemCategoryEntity) = db.itemCategoryDao().insertCategory(category)
     fun insertPlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().insertPlaceToBuy(placeToBuy)
     fun insertList(listEntity: ListEntity) = db.listDao().insertList(listEntity)

     fun deleteItem(item: ItemEntity) = db.itemDao().deleteItem(item)
     fun deleteCategory(category: ItemCategoryEntity) = db.itemCategoryDao().deleteCategory(category)
     fun deletePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().deletePlaceToBuy(placeToBuy)
     fun deleteListById(listId: Long) = db.listDao().deleteList(listId)
     fun deleteItemsByListId(listId: Long) = db.itemDao().deleteItemsByListId(listId)

     fun updateItem(item: ItemEntity) = db.itemDao().updateItem(item)
     fun updateCategory(category: ItemCategoryEntity) = db.itemCategoryDao().updateCategory(category)
     fun updatePlaceToBuy(placeToBuy: ItemPlaceToBuyEntity) = db.itemPlaceToBuyDao().updatePlaceToBuy(placeToBuy)
     fun updateList(list: ListEntity) = db.listDao().updateList(list)
}


