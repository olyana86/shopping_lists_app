package com.example.shoppinglistsapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
import com.example.shoppinglistsapp.presentation.adapter.AllCategoriesMainRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.adapter.AllListsMainRecyclerViewAdapter
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
            listItemClicked(
                listEntity
            )
        }
        binding.allUserListsMainRecyclerview.adapter = adapterUserLists
        viewModel.getUserLists().observe(this, Observer {
        adapterUserLists.setList(it)
        adapterUserLists.notifyDataSetChanged()
        })

        binding.addNewListFab.setOnClickListener {
            val navigateToNewList = Intent(this, NewUserListActivity::class.java)
            startActivity(navigateToNewList)
        }

        binding.firstPriorityBtn.setOnClickListener {
            val navigateToFirstPriorityList = Intent(this, PriorityAutoListActivity::class.java)
            startActivity(navigateToFirstPriorityList)
        }

        binding.secondPriorityBtn.setOnClickListener {
            val navigateToSecondPriorityList = Intent(this, PriorityAutoListActivity::class.java)
            startActivity(navigateToSecondPriorityList)
        }

        binding.thirdPriorityBtn.setOnClickListener {
            val navigateToThirdPriorityList = Intent(this, PriorityAutoListActivity::class.java)
            startActivity(navigateToThirdPriorityList)
        }

        binding.allCategoriesMainRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterCategories = AllCategoriesMainRecyclerViewAdapter { itemCategoryEntity: ItemCategoryEntity ->
            categoriesItemClicked(
                itemCategoryEntity
            )
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
        Toast.makeText(this,"selected name is ${listEntity.listName}",Toast.LENGTH_LONG).show()
    }

    private fun categoriesItemClicked(itemCategoryEntity: ItemCategoryEntity){
        Toast.makeText(this,"selected name is ${itemCategoryEntity.categoryName}",Toast.LENGTH_LONG).show()
    }


}