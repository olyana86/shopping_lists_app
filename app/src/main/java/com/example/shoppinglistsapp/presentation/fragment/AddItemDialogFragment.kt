package com.example.shoppinglistsapp.presentation.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.data.entity.ItemEntity
import com.example.shoppinglistsapp.databinding.FragmentEditableItemDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddItemDialogClickListener
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlin.math.absoluteValue


class AddItemDialogFragment(var addItemListener: AddItemDialogClickListener) :
DialogFragment() {
    private var _binding:FragmentEditableItemDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentEditableItemDialogBinding.inflate(
            inflater, container, false)

        binding.dialogItemCancelBtn.setOnClickListener {
            dismiss()
        }

        var itemPriority: Long = 2

        binding.dialogPriorityChips.setOnCheckedStateChangeListener { group, checkedIds ->
           val chipId = group.checkedChipId
            itemPriority = if (chipId == binding.addItemChipOne.id) {
                1
            } else if (chipId == binding.addItemChipTwo.id) {
                2
            } else {
                3
            }
        }

        binding.dialogItemSaveBtn.setOnClickListener {
            val itemTitle = binding.dialogItemTitleInputTextview.text.toString()
            if (itemTitle != "") {
                var itemPrice = 0
                if (binding.dialogItemPriceInputTextview.text.toString() != "") {
                    itemPrice = binding.dialogItemPriceInputTextview.text.toString().toInt()
                }
                var itemQuantity = "1 шт."
                if (binding.dialogItemQuantityInputTextview.text.toString() != "") {
                   itemQuantity = binding.dialogItemQuantityInputTextview.text.toString()
                }
                val addedItem = ItemEntity(item_id = null, itemName = itemTitle,
                itemQuantity = itemQuantity, itemPrice = itemPrice, itemPriorityId = itemPriority,
                itemCategoryId = null, itemPlaceToBuyId = null, itemListId = 1, itemIsBought = false)
                addItemListener.addItem(addedItem)
            }
            dismissAllowingStateLoss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}