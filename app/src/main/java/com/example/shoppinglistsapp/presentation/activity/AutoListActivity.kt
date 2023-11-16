package com.example.shoppinglistsapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import com.example.shoppinglistsapp.databinding.ActivityAutoListBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddItemDialogClickListener
import com.example.shoppinglistsapp.presentation.`interface`.ItemsRecyclerClickListener
import com.example.shoppinglistsapp.presentation.`interface`.UpdateItemDialogClickListener
import com.example.shoppinglistsapp.presentation.adapter.UserListItemsRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.fragment.AddItemDialogFragment
import com.example.shoppinglistsapp.presentation.fragment.EditItemDialogFragment
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

        val autoListType = intent.getStringExtra("TYPE")
        val autoListTitle = intent.getStringExtra("NAME")
        binding.autoListTitle.text = autoListTitle

        binding.allItemsAutoListRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterAutoListItems = UserListItemsRecyclerViewAdapter(object :
        ItemsRecyclerClickListener {
            override fun onItemClicked(itemEntity: ItemEntity) {
                val editDialog = EditItemDialogFragment(object : UpdateItemDialogClickListener {
                    override fun updateItem(itemEntity: ItemEntity) {
                        viewModel.updateItem(itemEntity)
                    }
                }, itemEntity)
                editDialog.show(supportFragmentManager, "editItemDialog")
            }

            override fun onCheckItemClicked(itemEntity: ItemEntity) {
                itemEntity.itemIsBought = !itemEntity.itemIsBought
                viewModel.updateItem(itemEntity)
            }

            override fun onDeleteItemClicked(itemEntity: ItemEntity) {
                viewModel.deleteItem(itemEntity)
            }
        })
        binding.allItemsAutoListRecyclerview.adapter = adapterAutoListItems

        when (autoListType) {
            "category" -> {
                val categoryId = intent.getLongExtra("ID", 1)

                viewModel.getItemsByCategoryId(categoryId).observe(this, Observer {
                    adapterAutoListItems.setItemsList(it)
                    adapterAutoListItems.notifyDataSetChanged()
                    var totalSum = 0
                    var remainingSum = 0
                    if (!it.isNullOrEmpty()) {
                        for (item in it) {
                            totalSum += item.itemPrice
                            if (!item.itemIsBought) {
                                remainingSum += item.itemPrice
                            }
                        }
                    }
                    binding.autoListSumTextview.text = "Сумма: $totalSum"
                    binding.autoListRemainingSumTextview.text = "Ещё: $remainingSum"
                })
                binding.addNewItemAutoListFab.setOnClickListener {
                    val newDialog = AddItemDialogFragment(object : AddItemDialogClickListener {
                        override fun addItem(itemEntity: ItemEntity) {
                            itemEntity.itemListId = 1
                            itemEntity.itemCategoryId = categoryId
                            viewModel.addItem(itemEntity)
                        }
                    })
                    newDialog.show(supportFragmentManager, "addItemDialog")
                }
            }
            "priority" -> {
                val priorityId: Long = intent.getLongExtra("ID", 1)

                viewModel.getItemsByPriorityId(priorityId).observe(this, Observer {
                    adapterAutoListItems.setItemsList(it)
                    adapterAutoListItems.notifyDataSetChanged()
                    var totalSum = 0
                    var remainingSum = 0
                    if (!it.isNullOrEmpty()) {
                        for (item in it) {
                            totalSum += item.itemPrice
                            if (!item.itemIsBought) {
                                remainingSum += item.itemPrice
                            }
                        }
                    }
                    binding.autoListSumTextview.text = "Сумма: $totalSum"
                    binding.autoListRemainingSumTextview.text = "Ещё: $remainingSum"
                })
                binding.addNewItemAutoListFab.setOnClickListener {
                    val newDialog = AddItemDialogFragment(object : AddItemDialogClickListener {
                        override fun addItem(itemEntity: ItemEntity) {
                            itemEntity.itemListId = 1
                            itemEntity.itemPriorityId = priorityId
                            viewModel.addItem(itemEntity)
                        }
                    })
                    newDialog.show(supportFragmentManager, "addItemDialog")
                }
            }
            "place" -> {
                val placeToBuyId = intent.getLongExtra("ID", 1)
                val placeToBuyAddress = intent.getStringExtra("ADDRESS")
                binding.autoListDescription.isVisible = true
                binding.autoListDescription.text = placeToBuyAddress

                viewModel.getItemsByPlaceToBuyId(placeToBuyId).observe(this, Observer {
                    adapterAutoListItems.setItemsList(it)
                    adapterAutoListItems.notifyDataSetChanged()
                    var totalSum = 0
                    var remainingSum = 0
                    if (!it.isNullOrEmpty()) {
                        for (item in it) {
                            totalSum += item.itemPrice
                            if (!item.itemIsBought) {
                                remainingSum += item.itemPrice
                            }
                        }
                    }
                    binding.autoListSumTextview.text = "Сумма: $totalSum"
                    binding.autoListRemainingSumTextview.text = "Ещё: $remainingSum"
                })
                binding.addNewItemAutoListFab.setOnClickListener {
                    val newDialog = AddItemDialogFragment(object : AddItemDialogClickListener {
                        override fun addItem(itemEntity: ItemEntity) {
                            itemEntity.itemListId = 1
                            itemEntity.itemPlaceToBuyId = placeToBuyId
                            viewModel.addItem(itemEntity)
                        }
                    })
                    newDialog.show(supportFragmentManager, "addItemDialog")
                }
            }
        }

    }
}