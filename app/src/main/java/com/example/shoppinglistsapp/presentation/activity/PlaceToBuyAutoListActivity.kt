package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityPlaceToBuyAutoListBinding

class PlaceToBuyAutoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPlaceToBuyAutoListBinding = DataBindingUtil.setContentView(this, R.layout.activity_place_to_buy_auto_list)

        binding.managePlaceautolistBtn.setOnClickListener {
            binding.placeautolistChipsFrame
        }

        binding.allItemsPlaceautolistRecyclerview

        binding.addNewItemPlaceautolistFab.setOnClickListener {

        }
    }
}