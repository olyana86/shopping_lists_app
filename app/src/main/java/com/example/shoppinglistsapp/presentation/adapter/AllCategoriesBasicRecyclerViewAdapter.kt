package com.example.shoppinglistsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.databinding.RecyclerCategoryBinding
import com.example.shoppinglistsapp.presentation.`interface`.BasicCategoryRecyclerClickListener

class AllCategoriesBasicRecyclerViewAdapter(var listener: BasicCategoryRecyclerClickListener) :
RecyclerView.Adapter<AllCategoriesBasicRecyclerViewAdapter.CategoriesBasicViewHolder>() {

    val basicCategories = ArrayList<ItemCategoryEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesBasicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerCategoryBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.recycler_category, parent, false)
        return CategoriesBasicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesBasicViewHolder, position: Int) {
        holder.bind(basicCategories[position])
        holder.binding.oneCategoryItem.setOnClickListener {
            val chosenCategory: ItemCategoryEntity = basicCategories[position]
            listener.onItemClicked(chosenCategory)
        }
    }

    override fun getItemCount(): Int {
        return basicCategories.size
    }

    fun setBasicCategoriesList(categoriesTitles: List<ItemCategoryEntity>) {
        basicCategories.clear()
        basicCategories.addAll(categoriesTitles)
    }

    class CategoriesBasicViewHolder(val  binding: RecyclerCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemCategoryEntity: ItemCategoryEntity) {
            binding.categoryTitleText.text = itemCategoryEntity.categoryName
        }
    }
}