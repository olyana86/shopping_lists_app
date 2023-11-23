package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.databinding.FragmentEditableItemDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.UpdateItemDialogClickListener

class EditItemDialogFragment(
    var updateItemListener: UpdateItemDialogClickListener,
    itemEntity: ItemEntity
) : DialogFragment() {

    private var _binding: FragmentEditableItemDialogBinding? = null
    private val binding get() = _binding!!

    private val oldItemTitle = itemEntity.itemName
    private val oldItemQuantity = itemEntity.itemQuantity
    private val oldItemPrice = itemEntity.itemPrice.toString()
    private var itemPriorityId = itemEntity.itemPriorityId
    private val itemId = itemEntity.item_id
    private val itemListId = itemEntity.itemListId
    private val itemIsBought = itemEntity.itemIsBought
    private val itemCategoryId = itemEntity.itemCategoryId
    private val itemPlaceToBuyId = itemEntity.itemPlaceToBuyId

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditableItemDialogBinding.inflate(
            inflater, container, false
        )

        binding.dialogItemTitleInputTextview.setText(oldItemTitle)
        binding.dialogItemQuantityInputTextview.setText(oldItemQuantity)
        binding.dialogItemPriceInputTextview.setText(oldItemPrice)

        binding.dialogItemCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.dialogPriorityChips.setOnCheckedStateChangeListener { group, checkedIds ->
            val chipId = group.checkedChipId
            itemPriorityId = if (chipId == binding.addItemChipOne.id) {
                1
            } else if (chipId == binding.addItemChipTwo.id) {
                2
            } else {
                3
            }
        }

        binding.dialogItemSaveBtn.setOnClickListener {
            val newItemTitle = binding.dialogItemTitleInputTextview.text.toString()
            var newItemQuantity = oldItemQuantity
            var newItemPrice = oldItemPrice.toInt()

            if (newItemTitle == "") {
                dismiss()
            } else {
                if (binding.dialogItemQuantityInputTextview.text.toString() != "") {
                    newItemQuantity = binding.dialogItemQuantityInputTextview.text.toString()
                }

                if (binding.dialogItemPriceInputTextview.text.toString() != "") {
                    newItemPrice = binding.dialogItemPriceInputTextview.text.toString().toInt()
                }

                val editedItem = ItemEntity(
                    item_id = itemId,
                    itemName = newItemTitle,
                    itemQuantity = newItemQuantity,
                    itemPrice = newItemPrice,
                    itemPriorityId = itemPriorityId,
                    itemCategoryId = itemCategoryId,
                    itemPlaceToBuyId = itemPlaceToBuyId,
                    itemListId = itemListId,
                    itemIsBought = itemIsBought
                )
                updateItemListener.updateItem(editedItem)
            }
            dismiss()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}