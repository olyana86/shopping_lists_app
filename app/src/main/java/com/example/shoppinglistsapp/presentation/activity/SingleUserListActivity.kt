package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import com.example.shoppinglistsapp.presentation.`interface`.UpdateListDialogClickListener
import com.example.shoppinglistsapp.presentation.adapter.UserListItemsRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.fragment.AddItemDialogFragment
import com.example.shoppinglistsapp.presentation.fragment.EditListDialogFragment
import com.example.shoppinglistsapp.presentation.viewmodel.SingleUserListViewModel
import com.example.shoppinglistsapp.presentation.viewmodel.SingleUserListViewModelFactory

class SingleUserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySingleUserListBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_single_user_list)

        val database = ShoppingListsDatabase.getInstance(this)
        val repository = ShoppingListsRepository(database)
        val factory = SingleUserListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[SingleUserListViewModel::class.java]

        val oldListTitle = intent.getStringExtra("NAME")
        val listId = intent.getLongExtra("ID", 0)

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

        binding.deleteListBtn.setOnClickListener {

        }

        binding.userListItemsRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterUserListItems = UserListItemsRecyclerViewAdapter(object :
        ItemsRecyclerClickListener {
            override fun onItemClicked(itemEntity: ItemEntity) {
                TODO("Not yet implemented")
            }

            override fun onCheckItemClicked(itemEntity: ItemEntity) {
                viewModel.updateItem(itemEntity)
            }

            override fun onDeleteItemClicked(itemEntity: ItemEntity) {
                viewModel.deleteItem(itemEntity)
            }
        })
        binding.userListItemsRecyclerview.adapter = adapterUserListItems
        viewModel.getItemsByListId(listId).observe(this, Observer {
            adapterUserListItems.setItemsList(it)
            adapterUserListItems.notifyDataSetChanged()
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
    }
}