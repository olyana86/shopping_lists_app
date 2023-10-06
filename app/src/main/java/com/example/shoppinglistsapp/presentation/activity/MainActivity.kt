package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

private lateinit var binding: ActivityMainBinding
lateinit var userListsRecyclerView: RecyclerView
lateinit var categoriesRecyclerView: RecyclerView
lateinit var addNewListFab: ExtendedFloatingActionButton
lateinit var firstPriorityBtn: MaterialButton
lateinit var secondPriorityBtn: MaterialButton
lateinit var thirdPriorityBtn: MaterialButton
lateinit var allCategoriesBtn: MaterialButton
lateinit var allPlacesToBuyBtn: MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userListsRecyclerView = findViewById(R.id.all_user_lists_main_recyclerview)
        categoriesRecyclerView = findViewById(R.id.all_categories_main_recyclerview)
        addNewListFab = findViewById(R.id.add_new_list_fab)
        firstPriorityBtn = findViewById(R.id.first_priority_btn)
        secondPriorityBtn = findViewById(R.id.second_priority_btn)
        thirdPriorityBtn = findViewById(R.id.third_priority_btn)
        allCategoriesBtn = findViewById(R.id.all_categories_btn)
        allPlacesToBuyBtn = findViewById(R.id.all_places_to_buy_btn)

    }
}