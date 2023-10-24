package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.databinding.FragmentEditableCategoryDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.UpdateCategoryDialogClickListener

class EditCategoryDialogFragment(var updateCategoryListener: UpdateCategoryDialogClickListener,
itemCategoryEntity: ItemCategoryEntity) :
        DialogFragment() {

    private var _binding: FragmentEditableCategoryDialogBinding? = null
    private val binding get() = _binding!!
    private val oldCategoryTitle = itemCategoryEntity.categoryName
    private val categoryId = itemCategoryEntity.category_id

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditableCategoryDialogBinding.inflate(
            inflater, container, false)

        binding.dialogCategoryTitleInputTextview.setText(oldCategoryTitle)

        binding.dialogCategoryCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.dialogCategorySaveBtn.setOnClickListener {
            var categoryTitle = binding.dialogCategoryTitleInputTextview.text.toString()
            if(categoryTitle == null) {
                dismiss()
            } else {
                val editedCategory = ItemCategoryEntity(category_id = categoryId,
                categoryName = categoryTitle, categoryIsEditable = true, categoryIsDeletable = true)
                updateCategoryListener.updateCategory(editedCategory)
                dismiss()
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}