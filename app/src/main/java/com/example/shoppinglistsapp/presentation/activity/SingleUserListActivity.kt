package com.example.shoppinglistsapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import com.example.shoppinglistsapp.databinding.ActivitySingleUserListBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddItemDialogClickListener
import com.example.shoppinglistsapp.presentation.`interface`.ItemsRecyclerClickListener
import com.example.shoppinglistsapp.presentation.`interface`.UpdateItemDialogClickListener
import com.example.shoppinglistsapp.presentation.`interface`.UpdateListDialogClickListener
import com.example.shoppinglistsapp.presentation.adapter.UserListItemsRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.fragment.AddItemDialogFragment
import com.example.shoppinglistsapp.presentation.fragment.EditItemDialogFragment
import com.example.shoppinglistsapp.presentation.fragment.EditListDialogFragment
import com.example.shoppinglistsapp.presentation.viewmodel.SingleUserListViewModel
import com.example.shoppinglistsapp.presentation.viewmodel.SingleUserListViewModelFactory

class SingleUserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySingleUserListBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_single_user_list
        )

        val database = ShoppingListsDatabase.getInstance(this)
        val repository = ShoppingListsRepository(database)
        val factory = SingleUserListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[SingleUserListViewModel::class.java]

        val oldListTitle = intent.getStringExtra("NAME")
        val listId = intent.getLongExtra("ID", 1)

        binding.listTitleTextview.text = oldListTitle

        binding.userListTitleEditBtn.setOnClickListener {
            val editTitleDialog = EditListDialogFragment(object : UpdateListDialogClickListener {
                override fun updateList(listTitle: String) {
                    val newList = ListEntity(list_id = listId, listName = listTitle)
                    viewModel.updateListTitle(newList)
                    binding.listTitleTextview.text = listTitle
                }
            }, oldListTitle)
            editTitleDialog.show(supportFragmentManager, "editListTitleDialog")
        }

        binding.userListItemsRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterUserListItems = UserListItemsRecyclerViewAdapter(object :
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
        binding.userListItemsRecyclerview.adapter = adapterUserListItems
        viewModel.getItemsByListId(listId).observe(this, Observer { it ->
            adapterUserListItems.setItemsList(it)
            adapterUserListItems.notifyDataSetChanged()
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
            binding.listSumTextview.text = "Сумма: $totalSum"
            binding.listRemainingSumTextview.text = "Ещё: $remainingSum"
        })

        binding.addNewItemFab.setOnClickListener {
            val newDialog = AddItemDialogFragment(object : AddItemDialogClickListener {
                override fun addItem(itemEntity: ItemEntity) {
                    itemEntity.itemListId = listId
                    viewModel.addItem(itemEntity)
                }
            })
            newDialog.show(supportFragmentManager, "addItemDialog")
        }

        val listIdString = listId.toString()
        if (listIdString != "1") {
            binding.deleteListBtn.isVisible = true
            binding.deleteListBtn.setOnClickListener {
                viewModel.deleteItemsByListId(listId)
                viewModel.deleteList(listId)
                val navigateToMainActivity = Intent(this, MainActivity::class.java)
                startActivity(navigateToMainActivity)
            }
        }
    }

}