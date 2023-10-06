package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityCommonAutoListBinding

class CommonAutoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCommonAutoListBinding = DataBindingUtil.setContentView(this, R.layout.activity_common_auto_list)
    }
}