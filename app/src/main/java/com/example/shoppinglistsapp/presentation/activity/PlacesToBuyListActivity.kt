package com.example.shoppinglistsapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import com.example.shoppinglistsapp.databinding.ActivityPlacesToBuyListBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddPlaceToBuyDialogClickListener
import com.example.shoppinglistsapp.presentation.`interface`.PlacesToBuyRecyclerClickListener
import com.example.shoppinglistsapp.presentation.`interface`.UpdatePlaceToBuyDialogClickListener
import com.example.shoppinglistsapp.presentation.adapter.AllPlacesToBuyEditableRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.fragment.AddPlaceToBuyDialogFragment
import com.example.shoppinglistsapp.presentation.fragment.EditPlaceToBuyDialogFragment
import com.example.shoppinglistsapp.presentation.viewmodel.PlacesToBuyListViewModel
import com.example.shoppinglistsapp.presentation.viewmodel.PlacesToBuyListViewModelFactory

class PlacesToBuyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPlacesToBuyListBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_places_to_buy_list
        )

        val database = ShoppingListsDatabase.getInstance(this)
        val repository = ShoppingListsRepository(database)
        val factory = PlacesToBuyListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[PlacesToBuyListViewModel::class.java]

        binding.allPlacesToBuyRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterPlacesToBuy = AllPlacesToBuyEditableRecyclerViewAdapter(object :
            PlacesToBuyRecyclerClickListener {
            override fun onPlaceToBuyClicked(itemPlaceToBuyEntity: ItemPlaceToBuyEntity) {
                placeToBuyItemClicked(itemPlaceToBuyEntity)
            }

            override fun onEditPlaceToBuyClicked(itemPlaceToBuyEntity: ItemPlaceToBuyEntity) {
                val editDialog =
                    EditPlaceToBuyDialogFragment(object : UpdatePlaceToBuyDialogClickListener {
                        override fun updatePlaceToBuy(itemPlaceToBuyEntity: ItemPlaceToBuyEntity) {
                            viewModel.updatePlaceToBuy(itemPlaceToBuyEntity)
                        }
                    }, itemPlaceToBuyEntity)
                editDialog.show(supportFragmentManager, "editPlaceToBuyDialog")
            }

            override fun onDeletePlaceToBuyClicked(itemPlaceToBuyEntity: ItemPlaceToBuyEntity) {
                viewModel.deletePlaceToBuy(itemPlaceToBuyEntity)
            }
        })
        binding.allPlacesToBuyRecyclerview.adapter = adapterPlacesToBuy
        viewModel.getPlacesToBuy().observe(this, Observer {
            adapterPlacesToBuy.setAllPlacesToBuyList(it)
            adapterPlacesToBuy.notifyDataSetChanged()
        })

        binding.addNewPlaceToBuyFab.setOnClickListener {
            val newDialog = AddPlaceToBuyDialogFragment(object : AddPlaceToBuyDialogClickListener {
                override fun addPlaceToBuy(itemPlaceToBuyEntity: ItemPlaceToBuyEntity) {
                    viewModel.addPlaceToBuy(itemPlaceToBuyEntity)
                }
            })
            newDialog.show(supportFragmentManager, "addPlaceToBuyDialog")
        }
    }

    fun placeToBuyItemClicked(itemPlaceToBuyEntity: ItemPlaceToBuyEntity) {
        val placeToBuyId = itemPlaceToBuyEntity.place_to_buy_id
        val placeToBuyName = itemPlaceToBuyEntity.placeToBuyName
        val placeToBuyAddress = itemPlaceToBuyEntity.placeToBuyAddress
        val navigateToChosenPlaceToBuyList = Intent(
            this,
            AutoListActivity::class.java
        )
        navigateToChosenPlaceToBuyList.putExtra("ID", placeToBuyId)
        navigateToChosenPlaceToBuyList.putExtra("NAME", placeToBuyName)
        navigateToChosenPlaceToBuyList.putExtra("ADDRESS", placeToBuyAddress)
        navigateToChosenPlaceToBuyList.putExtra("TYPE", "place")
        navigateToChosenPlaceToBuyList.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(navigateToChosenPlaceToBuyList)
    }
}