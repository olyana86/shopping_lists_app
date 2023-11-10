package com.example.shoppinglistsapp.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.databinding.RecyclerItemFullBinding
import com.example.shoppinglistsapp.presentation.`interface`.ItemsRecyclerClickListener

class UserListItemsRecyclerViewAdapter(var clickListener: ItemsRecyclerClickListener) :
RecyclerView.Adapter<UserListItemsRecyclerViewAdapter.ItemsViewHolder>() {
    var editableItems = ArrayList<ItemEntity>()
    var allBoughtItemsIds = getBoughtItemsIds(editableItems)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerItemFullBinding = DataBindingUtil.inflate(layoutInflater,
        R.layout.recycler_item_full, parent, false)
        return ItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(editableItems[position])

        holder.binding.oneFullItemDeleteBtn.setOnClickListener {
            val deletedItem: ItemEntity = editableItems[position]
            clickListener.onDeleteItemClicked(deletedItem)
        }
        holder.binding.oneFullItem.setOnClickListener {
            val chosenItem: ItemEntity = editableItems[position]
            clickListener.onItemClicked(chosenItem)
        }

        holder.binding.oneFullItemCheckBox.setOnCheckedChangeListener { compoundButton, b ->
            val checkedItem: ItemEntity = editableItems[position]
            clickListener.onCheckItemClicked(checkedItem)
        }
    }

    override fun getItemCount(): Int {
        return editableItems.size
    }

    fun setItemsList(itemsNames: List<ItemEntity>) {
        editableItems.clear()
        editableItems.addAll(itemsNames)
    }


    class ItemsViewHolder(val binding: RecyclerItemFullBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(itemEntity: ItemEntity) {
                    binding.oneFullItemTitleText.text = itemEntity.itemName

                    val thisItemPrice = itemEntity.itemPrice
                    val thisItemQuantity = itemEntity.itemQuantity
                    val thisItemPriceAndQuantity = "Цена: $thisItemPrice, $thisItemQuantity"
                    binding.oneFullItemPriceAndQuantityText.text = thisItemPriceAndQuantity
            }

    }

    fun getBoughtItemsIds(listItems: ArrayList<ItemEntity>): ArrayList<String> {
        var boughtItemsIds = ArrayList<String>()
        for (item in listItems) {
            if (item.itemIsBought == true) {
                val itemId = item.item_id.toString()
                if (itemId != "") {
                    boughtItemsIds.add(itemId)
                }
            }
        }
        return boughtItemsIds
    }

}