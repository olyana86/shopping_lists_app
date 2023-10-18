package com.example.shoppinglistsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.databinding.RecyclerListBinding

class AllListsMainRecyclerViewAdapter(private val clickListener: (ListEntity) -> Unit) :
RecyclerView.Adapter<UserListsViewHolder>() {
    private val userLists = ArrayList<ListEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_list, parent, false)
        return UserListsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListsViewHolder, position: Int) {
        holder.bind(userLists[position], clickListener)
    }

    override fun getItemCount(): Int {
        return userLists.size
    }

    fun setList(listsTitles: List<ListEntity>) {
        userLists.clear()
        userLists.addAll(listsTitles)
    }

}

class UserListsViewHolder (val binding: RecyclerListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(listEntity: ListEntity, clickListener: (ListEntity) -> Unit) {
        binding.listTitleText.text = listEntity.listName

        binding.oneListItem.setOnClickListener {
            clickListener(listEntity)
        }
    }
}