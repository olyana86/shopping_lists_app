package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityPriorityAutoListBinding

class PriorityAutoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPriorityAutoListBinding = DataBindingUtil.setContentView(this, R.layout.activity_priority_auto_list)
    }
}