package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.databinding.FragmentEditableCategoryDialogBinding
import com.example.shoppinglistsapp.databinding.FragmentEditablePlaceToBuyDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.AddPlaceToBuyDialogClickListener


class AddPlaceToBuyDialogFragment(var addPlaceToBuyListener: AddPlaceToBuyDialogClickListener) :
    DialogFragment() {

    private var _binding:FragmentEditablePlaceToBuyDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentEditablePlaceToBuyDialogBinding.inflate(
           inflater, container, false)

       binding.dialogPlaceCancelBtn.setOnClickListener {
           dismiss()
       }
       binding.dialogPlaceSaveBtn.setOnClickListener {
           var newPlaceToBuyTitle: String? = binding.dialogPlaceTitleInputTextview.text.toString()
           var newPlaceToBuyAddress: String? = binding.dialogPlaceAddressInputTextview.text.toString()
           if (newPlaceToBuyTitle == null) {
               dismiss()
           } else {
               val newPlaceToBuy = ItemPlaceToBuyEntity(place_to_buy_id = null,
               placeToBuyName = newPlaceToBuyTitle, placeToBuyAddress = newPlaceToBuyAddress)
               addPlaceToBuyListener.addPlaceToBuy(newPlaceToBuy)
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