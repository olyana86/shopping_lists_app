package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.data.entity.ListEntity
import com.example.shoppinglistsapp.databinding.FragmentEditableListTitleDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddListDialogClickListener


class AddListDialogFragment(var addListListener: AddListDialogClickListener) :
    DialogFragment() {

    private var _binding: FragmentEditableListTitleDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditableListTitleDialogBinding.inflate(
            inflater, container, false)

        binding.dialogListTitleCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.dialogListTitleSaveBtn.setOnClickListener {
            val listTitle = binding.dialogListTitleInputTextview.text.toString()
            if (listTitle != "") {
                val newList = ListEntity(list_id = null, listName = listTitle)
                addListListener.addList(newList)
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