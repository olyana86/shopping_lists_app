package com.example.shoppinglistsapp.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.database.ShoppingListsDatabase
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.data.repository.ShoppingListsRepository
import com.example.shoppinglistsapp.databinding.ActivityCategoriesListBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddCategoryDialogClickListener
import com.example.shoppinglistsapp.presentation.`interface`.EditableCategoryRecyclerClickListener
import com.example.shoppinglistsapp.presentation.`interface`.UpdateCategoryDialogClickListener
import com.example.shoppinglistsapp.presentation.adapter.AllCategoriesEditableRecyclerViewAdapter
import com.example.shoppinglistsapp.presentation.fragment.AddCategoryDialogFragment
import com.example.shoppinglistsapp.presentation.fragment.EditCategoryDialogFragment
import com.example.shoppinglistsapp.presentation.viewmodel.CategoriesListViewModel
import com.example.shoppinglistsapp.presentation.viewmodel.CategoriesListViewModelFactory

class CategoriesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCategoriesListBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_categories_list)

        val database = ShoppingListsDatabase.getInstance(this)
        val repository = ShoppingListsRepository(database)
        val factory = CategoriesListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[CategoriesListViewModel::class.java]

        binding.allCategoriesRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapterCategories = AllCategoriesEditableRecyclerViewAdapter(object : EditableCategoryRecyclerClickListener {
            override fun onItemClicked(itemCategoryEntity: ItemCategoryEntity) {
                categoryItemClicked(itemCategoryEntity)
            }

            override fun onEditItemClicked(itemCategoryEntity: ItemCategoryEntity) {
                val editDialog = EditCategoryDialogFragment(object : UpdateCategoryDialogClickListener {
                    override fun updateCategory(itemCategoryEntity: ItemCategoryEntity) {
                        viewModel.updateCategory(itemCategoryEntity)
                    }
                }, itemCategoryEntity)
                editDialog.show(supportFragmentManager, "editCategoryDialog")
            }

            override fun onDeleteItemClicked(itemCategoryEntity: ItemCategoryEntity) {
                viewModel.deleteCategory(itemCategoryEntity)
            }
        })
        binding.allCategoriesRecyclerview.adapter = adapterCategories
        viewModel.getEditableCategories(true).observe(this, Observer {
            adapterCategories.setAllCategoriesList(it)
            adapterCategories.notifyDataSetChanged()
        })

        binding.addNewCategoryFab.setOnClickListener {
            val newDialog = AddCategoryDialogFragment(object : AddCategoryDialogClickListener {
                override fun addCategory(itemCategoryEntity: ItemCategoryEntity) {
                    viewModel.addCategory(itemCategoryEntity)
                }
            })
            newDialog.show(supportFragmentManager, "addCategoryDialog")
        }
    }

    private fun categoryItemClicked(itemCategoryEntity: ItemCategoryEntity) {
        val categoryId = itemCategoryEntity.category_id
        val categoryName = itemCategoryEntity.categoryName
        val navigateToChosenCategoryList = Intent(this,
            AutoListActivity::class.java)
        navigateToChosenCategoryList.putExtra("ID", categoryId)
        navigateToChosenCategoryList.putExtra("NAME", categoryName)
        navigateToChosenCategoryList.putExtra("TYPE", "category")
        navigateToChosenCategoryList.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(navigateToChosenCategoryList)
    }
}