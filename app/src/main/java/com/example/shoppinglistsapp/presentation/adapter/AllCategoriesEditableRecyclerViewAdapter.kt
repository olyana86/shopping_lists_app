package com.example.shoppinglistsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.databinding.RecyclerCategoryFullBinding

class AllCategoriesEditableRecyclerViewAdapter(private val clickListener: (ItemCategoryEntity) -> Unit) :
RecyclerView.Adapter<CategoriesEditableViewHolder>() {
    private val categories = ArrayList<ItemCategoryEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesEditableViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerCategoryFullBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_category_full, parent, false)
        return CategoriesEditableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesEditableViewHolder, position: Int) {
        holder.bind(categories[position], clickListener)
    }

    override fun getItemCount(): Int {
        return  categories.size
    }

    fun setAllCategoriesList(categoriesNames: List<ItemCategoryEntity>) {
        categories.clear()
        categories.addAll(categoriesNames)
    }
}

class CategoriesEditableViewHolder (val binding: RecyclerCategoryFullBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(itemCategoryEntity: ItemCategoryEntity, clickListener: (ItemCategoryEntity) -> Unit) {
        binding.fullCategoryTitleText.text = itemCategoryEntity.categoryName

        if(itemCategoryEntity.categoryIsEditable) {
        binding.fullCategoryEditBtn.isVisible = true
        }

        if(itemCategoryEntity.categoryIsDeletable) {
            binding.fullCategoryDeleteBtn.isVisible = true
            binding.fullCategoryDeleteBtn.setOnClickListener {

            }
        }

        binding.oneFullCategoryItem.setOnClickListener {
            clickListener(itemCategoryEntity)
        }
    }
}