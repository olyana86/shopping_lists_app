package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.databinding.FragmentEditableListTitleDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.UpdateListDialogClickListener

class EditListDialogFragment(var updateListListener: UpdateListDialogClickListener,
                             var listTitle: String?) : DialogFragment() {

    private var _binding: FragmentEditableListTitleDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditableListTitleDialogBinding.inflate(
            inflater, container, false)

        binding.dialogListTitleInputTextview.setText(listTitle)

        binding.dialogListTitleCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.dialogListTitleSaveBtn.setOnClickListener {
            val newListTitle = binding.dialogListTitleInputTextview.text.toString()
            if(newListTitle != "") {
                updateListListener.updateList(newListTitle)
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