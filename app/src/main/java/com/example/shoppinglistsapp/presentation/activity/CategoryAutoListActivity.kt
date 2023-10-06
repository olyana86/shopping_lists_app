package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityCategoryAutoListBinding

class CategoryAutoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCategoryAutoListBinding = DataBindingUtil.setContentView(this, R.layout.activity_category_auto_list)
    }
}