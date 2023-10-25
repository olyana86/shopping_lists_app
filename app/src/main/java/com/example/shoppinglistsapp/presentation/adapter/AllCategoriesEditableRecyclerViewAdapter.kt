package com.example.shoppinglistsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.databinding.RecyclerCategoryFullBinding
import com.example.shoppinglistsapp.presentation.`interface`.EditableCategoryRecyclerClickListener

class AllCategoriesEditableRecyclerViewAdapter(var editableCategoryRecyclerClickListener:
    EditableCategoryRecyclerClickListener) : RecyclerView.Adapter<AllCategoriesEditableRecyclerViewAdapter.
    CategoriesEditableViewHolder>() {
    val editableCategories = ArrayList<ItemCategoryEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CategoriesEditableViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerCategoryFullBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.recycler_category_full, parent, false)
        return CategoriesEditableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesEditableViewHolder, position: Int) {
        holder.bind(editableCategories[position])
        holder.binding.fullCategoryDeleteBtn.setOnClickListener {
            val deletedItem: ItemCategoryEntity = editableCategories[position]
            editableCategoryRecyclerClickListener.onDeleteItemClicked(deletedItem)
        }
        holder.binding.fullCategoryEditBtn.setOnClickListener {
            val editedItem: ItemCategoryEntity = editableCategories[position]
            editableCategoryRecyclerClickListener.onEditItemClicked(editedItem)
        }
        holder.binding.oneFullCategoryItem.setOnClickListener {
            val chosenItem: ItemCategoryEntity = editableCategories[position]
            editableCategoryRecyclerClickListener.onItemClicked(chosenItem)
        }
    }

    override fun getItemCount(): Int {
        return editableCategories.size
    }

    fun setAllCategoriesList(categoriesNames: List<ItemCategoryEntity>) {
        editableCategories.clear()
        editableCategories.addAll(categoriesNames)
    }

    class CategoriesEditableViewHolder(val binding: RecyclerCategoryFullBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemCategoryEntity: ItemCategoryEntity) {
            binding.fullCategoryTitleText.text = itemCategoryEntity.categoryName
        }
    }
}