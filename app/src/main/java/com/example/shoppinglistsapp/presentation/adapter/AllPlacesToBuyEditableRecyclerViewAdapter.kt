package com.example.shoppinglistsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.databinding.RecyclerPlaceToBuyFullBinding
import com.example.shoppinglistsapp.presentation.`interface`.PlacesToBuyRecyclerClickListener

class AllPlacesToBuyEditableRecyclerViewAdapter(
    var placesToBuyClickListener:
    PlacesToBuyRecyclerClickListener
) : RecyclerView.Adapter<AllPlacesToBuyEditableRecyclerViewAdapter.PlacesToBuyEditableViewHolder>() {
    private val editablePlacesToBuy = ArrayList<ItemPlaceToBuyEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PlacesToBuyEditableViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerPlaceToBuyFullBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.recycler_place_to_buy_full, parent, false
        )
        return PlacesToBuyEditableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlacesToBuyEditableViewHolder, position: Int) {
        holder.bind(editablePlacesToBuy[position])
        holder.binding.fullPlaceToBuyDeleteBtn.setOnClickListener {
            val deletedPlaceToBuy: ItemPlaceToBuyEntity = editablePlacesToBuy[position]
            placesToBuyClickListener.onDeletePlaceToBuyClicked(deletedPlaceToBuy)
        }
        holder.binding.fullPlaceToBuyEditBtn.setOnClickListener {
            val editedPlaceToBuy: ItemPlaceToBuyEntity = editablePlacesToBuy[position]
            placesToBuyClickListener.onEditPlaceToBuyClicked(editedPlaceToBuy)
        }
        holder.binding.oneFullPlaceToBuyItem.setOnClickListener {
            val chosenPlaceToBuy: ItemPlaceToBuyEntity = editablePlacesToBuy[position]
            placesToBuyClickListener.onPlaceToBuyClicked(chosenPlaceToBuy)
        }
    }

    override fun getItemCount(): Int {
        return editablePlacesToBuy.size
    }

    fun setAllPlacesToBuyList(placesToBuyNames: List<ItemPlaceToBuyEntity>) {
        editablePlacesToBuy.clear()
        editablePlacesToBuy.addAll(placesToBuyNames)
    }

    class PlacesToBuyEditableViewHolder(val binding: RecyclerPlaceToBuyFullBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemPlaceToBuyEntity: ItemPlaceToBuyEntity) {
            binding.fullPlaceToBuyTitleText.text = itemPlaceToBuyEntity.placeToBuyName
            binding.fullPlaceToBuyAddressText.text = itemPlaceToBuyEntity.placeToBuyAddress
        }
    }
}