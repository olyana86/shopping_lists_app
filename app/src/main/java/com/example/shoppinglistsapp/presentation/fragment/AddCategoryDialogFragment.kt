package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.data.entity.ItemCategoryEntity
import com.example.shoppinglistsapp.databinding.FragmentEditableCategoryDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddCategoryDialogClickListener

class AddCategoryDialogFragment(var addCategoryListener: AddCategoryDialogClickListener) :
                                        DialogFragment() {

    private var _binding: FragmentEditableCategoryDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditableCategoryDialogBinding.inflate(
            inflater, container, false)

        binding.dialogCategoryCancelBtn.setOnClickListener {
            dismiss()
        }
        binding.dialogCategorySaveBtn.setOnClickListener {
            var categoryTitle: String? = binding.dialogCategoryTitleInputTextview.text.toString()
            if(categoryTitle == null) {
                dismiss()
            } else {
                val newCategory = ItemCategoryEntity(category_id = null,
                    categoryName = categoryTitle, categoryIsEditable = true, categoryIsDeletable = true)
                addCategoryListener.addCategory(newCategory)
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