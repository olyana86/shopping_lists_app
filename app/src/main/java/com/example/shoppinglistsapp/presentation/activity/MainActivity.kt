package com.example.shoppinglistsapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.addNewListFab.setOnClickListener {
            val navigateToNewList = Intent(this, NewUserListActivity::class.java)
            startActivity(navigateToNewList)
        }

        binding.allCategoriesBtn.setOnClickListener {
            val navigateToAllCategories = Intent(this, CategoriesListActivity::class.java)
            startActivity(navigateToAllCategories)
        }

        binding.allPlacesToBuyBtn.setOnClickListener {
            val navigateToAllPlacesToBuy = Intent(this, PlacesToBuyListActivity::class.java)
            startActivity(navigateToAllPlacesToBuy)
        }

    }
}