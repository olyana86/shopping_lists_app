package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import com.example.shoppinglistsapp.databinding.ActivityAutoListBinding
import com.example.shoppinglistsapp.presentation.viewmodel.AutoListViewModel
import com.example.shoppinglistsapp.presentation.viewmodel.AutoListViewModelFactory

class AutoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAutoListBinding = DataBindingUtil.setContentView(this, R.layout.activity_auto_list)

        val database = ShoppingListsDatabase.getInstance(this)
        val repository = ShoppingListsRepository(database)
        val factory = AutoListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[AutoListViewModel::class.java]

        binding.allItemsAutoListRecyclerview

        binding.addNewItemAutoListFab.setOnClickListener {

        }
    }
}