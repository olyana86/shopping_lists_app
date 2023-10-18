package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityCategoriesListBinding
import com.example.shoppinglistsapp.presentation.fragment.EditableCategoryDialogFragment

class CategoriesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCategoriesListBinding = DataBindingUtil.setContentView(this, R.layout.activity_categories_list)

        binding.allCategoriesRecyclerview

        binding.addNewCategoryFab.setOnClickListener {

        }
    }
}