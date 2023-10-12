package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.databinding.FragmentEditableItemDialogBinding

class EditableItemDialogFragment : DialogFragment() {


    private var _binding: FragmentEditableItemDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditableItemDialogBinding.inflate(inflater,
            container, false)

        binding.itemDialogCancelBtn.setOnClickListener{
            dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}