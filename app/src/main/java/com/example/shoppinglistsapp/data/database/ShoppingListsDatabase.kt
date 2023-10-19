package com.example.shoppinglistsapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.shoppinglistsapp.data.dao.*
import com.example.shoppinglistsapp.data.entity.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(
    entities = [
        ItemEntity::class,
        ItemCategoryEntity::class,
        ItemPriorityEntity::class,
        ItemPlaceToBuyEntity::class,
        ListEntity::class
    ], version = ShoppingListsDatabase.DB_VERSION)

abstract class ShoppingListsDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun itemCategoryDao(): ItemCategoryDao
    abstract fun itemPriorityDao(): ItemPriorityDao
    abstract fun itemPlaceToBuyDao(): ItemPlaceToBuyDao
    abstract fun listDao(): ListDao
    abstract fun categoryWithItemsDao(): CategoryWithItemsDao
    abstract fun placeToBuyWithItemsDao(): PlaceToBuyWithItemsDao
    abstract fun priorityWithItemsDao(): PriorityWithItemsDao
    abstract fun listWithItemsDao(): ListWithItemsDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "app.db"

        @Volatile
        private var INSTANCE: ShoppingListsDatabase? = null

        fun getInstance(context: Context) : ShoppingListsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context)
            }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ShoppingListsDatabase::class.java, DB_NAME).addCallback(dbCreateCallback(context)).build()

        private fun dbCreateCallback(context: Context) =
            object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    GlobalScope.launch {
                        getInstance(context).itemPriorityDao().insertAllPriorities(PrepopulateData.priorities)
                        getInstance(context).itemCategoryDao().insertAllCategories(PrepopulateData.categories)
                        getInstance(context).listDao().insertList(PrepopulateData.commonList)
                    }
                }
            }
        object PrepopulateData {
            val commonList = ListEntity(
                list_id = 1,
                listName = "Общий список"
            )
            val priorities = listOf(
                ItemPriorityEntity(
                    priority_id = 1,
                    priorityName = "Очень надо"
                ),
                ItemPriorityEntity(
                    priority_id = 2,
                    priorityName = "Надо"
                ),
                ItemPriorityEntity(
                    priority_id = 3,
                    priorityName = "Пока подождет"
                )
            )
            val categories = listOf(
                ItemCategoryEntity(
                    category_id = 1,
                    categoryName = "Еда и напитки",
                    categoryIsEditable = false,
                    categoryIsDeletable = false
                ),
                    ItemCategoryEntity(
                    category_id = 2,
                    categoryName = "Одежда и обувь",
                    categoryIsEditable = false,
                    categoryIsDeletable = false
            ),
                ItemCategoryEntity(
                    category_id = 3,
                    categoryName = "Для дома",
                    categoryIsEditable = false,
                    categoryIsDeletable = false
                ),
                ItemCategoryEntity(
                    category_id = 4,
                    categoryName = "Красота и здоровье",
                    categoryIsEditable = false,
                    categoryIsDeletable = false
                ),
                ItemCategoryEntity(
                    category_id = 5,
                    categoryName = "Хобби",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                ),
                ItemCategoryEntity(
                    category_id = 6,
                    categoryName = "Для детей",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                ),
                ItemCategoryEntity(
                    category_id = 7,
                    categoryName = "Зоотовары",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                ),
                ItemCategoryEntity(
                    category_id = 8,
                    categoryName = "Спорт и отдых",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                ),
                ItemCategoryEntity(
                    category_id = 9,
                    categoryName = "Техника",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                ),
                ItemCategoryEntity(
                    category_id = 10,
                    categoryName = "Ремонт",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                ),
                ItemCategoryEntity(
                    category_id = 11,
                    categoryName = "Авто",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                ),
                ItemCategoryEntity(
                    category_id = 12,
                    categoryName = "Подарки",
                    categoryIsEditable = false,
                    categoryIsDeletable = true
                )
            )
        }
    }
}