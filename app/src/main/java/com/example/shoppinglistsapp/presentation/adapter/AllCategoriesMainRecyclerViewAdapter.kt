package com.example.shoppinglistsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.databinding.RecyclerCategoryBinding

class AllCategoriesMainRecyclerViewAdapter(private val clickListener: (ItemCategoryEntity) -> Unit) :
    RecyclerView.Adapter<CategoriesMainViewHolder>() {
    private val categories = ArrayList<ItemCategoryEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesMainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerCategoryBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.recycler_category, parent, false)
        return CategoriesMainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesMainViewHolder, position: Int) {
        holder.bind(categories[position], clickListener)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setCategoriesList(categoriesTitles: List<ItemCategoryEntity>) {
        categories.clear()
        categories.addAll(categoriesTitles)
    }
}

class CategoriesMainViewHolder(val binding: RecyclerCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(itemCategoryEntity: ItemCategoryEntity, clickListener: (ItemCategoryEntity) -> Unit) {
        binding.categoryTitleText.text = itemCategoryEntity.categoryName

        binding.oneCategoryItem.setOnClickListener {
            clickListener(itemCategoryEntity)
        }
    }
}