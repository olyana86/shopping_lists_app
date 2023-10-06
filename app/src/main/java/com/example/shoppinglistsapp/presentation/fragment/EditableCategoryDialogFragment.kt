package com.example.shoppinglistsapp.presentation.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.databinding.FragmentEditableCategoryDialogBinding

class EditableCategoryDialogFragment : DialogFragment() {

    private var _binding: FragmentEditableCategoryDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentEditableCategoryDialogBinding.inflate(LayoutInflater.from(context))
        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}