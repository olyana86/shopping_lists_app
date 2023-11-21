package com.example.shoppinglistsapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import com.example.shoppinglistsapp.databinding.ActivityMainBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddListDialogClickListener
import com.example.shoppinglistsapp.presentation.adapter.AllCategoriesMainRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.adapter.AllListsMainRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.fragment.AddListDialogFragment
import com.example.shoppinglistsapp.presentation.viewmodel.MainActivityViewModel
import com.example.shoppinglistsapp.presentation.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val database = ShoppingListsDatabase.getInstance(this)
        val repository = ShoppingListsRepository(database)
        val factory = MainActivityViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[MainActivityViewModel::class.java]

        binding.allUserListsMainRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterUserLists = AllListsMainRecyclerViewAdapter { listEntity: ListEntity ->
            listItemClicked(listEntity)
        }
        binding.allUserListsMainRecyclerview.adapter = adapterUserLists
        viewModel.getUserLists().observe(this, Observer {
        adapterUserLists.setList(it)
        adapterUserLists.notifyDataSetChanged()
        })

        binding.addNewListFab.setOnClickListener {
            val newListDialog = AddListDialogFragment(object : AddListDialogClickListener {
                override fun addList(listEntity: ListEntity) {
                    viewModel.addNewList(listEntity)
                }
            })
            newListDialog.show(supportFragmentManager, "addNewListDialog")
        }

        binding.firstPriorityBtn.setOnClickListener {
            val firstPriority: Long = 1
            val navigateToFirstPriorityList = Intent(this, AutoListActivity::class.java)
            navigateToFirstPriorityList.putExtra("ID", firstPriority)
            navigateToFirstPriorityList.putExtra("NAME", "Приоритет: срочно")
            navigateToFirstPriorityList.putExtra("TYPE", "priority")
            navigateToFirstPriorityList.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(navigateToFirstPriorityList)
        }

        binding.secondPriorityBtn.setOnClickListener {
            val secondPriority: Long = 2
            val navigateToSecondPriorityList = Intent(this, AutoListActivity::class.java)
            navigateToSecondPriorityList.putExtra("ID", secondPriority)
            navigateToSecondPriorityList.putExtra("NAME", "Приоритет: надо")
            navigateToSecondPriorityList.putExtra("TYPE", "priority")
            navigateToSecondPriorityList.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(navigateToSecondPriorityList)
        }

        binding.thirdPriorityBtn.setOnClickListener {
            val thirdPriority: Long = 3
            val navigateToThirdPriorityList = Intent(this, AutoListActivity::class.java)
            navigateToThirdPriorityList.putExtra("ID", thirdPriority)
            navigateToThirdPriorityList.putExtra("NAME", "Приоритет: подождёт")
            navigateToThirdPriorityList.putExtra("TYPE", "priority")
            navigateToThirdPriorityList.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(navigateToThirdPriorityList)
        }

        binding.allCategoriesMainRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterCategories = AllCategoriesMainRecyclerViewAdapter { itemCategoryEntity: ItemCategoryEntity ->
            categoriesItemClicked(itemCategoryEntity)
        }
        binding.allCategoriesMainRecyclerview.adapter = adapterCategories
        viewModel.getAllCategories().observe(this, Observer {
            adapterCategories.setCategoriesList(it)
            adapterCategories.notifyDataSetChanged()
        })

        binding.allCategoriesBtn.setOnClickListener {
            val navigateToAllCategories = Intent(this, CategoriesListActivity::class.java)
            startActivity(navigateToAllCategories)
        }

        binding.allPlacesToBuyBtn.setOnClickListener {
            val navigateToAllPlacesToBuy = Intent(this, PlacesToBuyListActivity::class.java)
            startActivity(navigateToAllPlacesToBuy)
        }
    }

    private fun listItemClicked(listEntity: ListEntity){
        val listId: Long? = listEntity.list_id
        val listName = listEntity.listName
        val navigateToUserList = Intent(this, SingleUserListActivity::class.java)
        navigateToUserList.putExtra("ID", listId)
        navigateToUserList.putExtra("NAME", listName)
        navigateToUserList.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(navigateToUserList)
    }

    private fun categoriesItemClicked(itemCategoryEntity: ItemCategoryEntity){
        val categoryId: Long? = itemCategoryEntity.category_id
        val categoryName = itemCategoryEntity.categoryName
        val navigateToChosenCategory = Intent(this, AutoListActivity::class.java)
        navigateToChosenCategory.putExtra("ID", categoryId)
        navigateToChosenCategory.putExtra("NAME", categoryName)
        navigateToChosenCategory.putExtra("TYPE", "category")
        navigateToChosenCategory.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(navigateToChosenCategory)
    }

}