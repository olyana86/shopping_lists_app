package com.example.shoppinglistsapp.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.data.entity.ItemPlaceToBuyEntity
import com.example.shoppinglistsapp.databinding.FragmentEditablePlaceToBuyDialogBinding
import com.example.shoppinglistsapp.presentation.`interface`.UpdatePlaceToBuyDialogClickListener

class EditPlaceToBuyDialogFragment(var updatePlaceToBuyListener: UpdatePlaceToBuyDialogClickListener,
itemPlaceToBuyEntity: ItemPlaceToBuyEntity) : DialogFragment() {

    private var _binding: FragmentEditablePlaceToBuyDialogBinding? = null
    private val binding get() = _binding!!
    private val oldPlaceToBuyTitle = itemPlaceToBuyEntity.placeToBuyName
    private val oldPlaceToBuyAddress: String? = itemPlaceToBuyEntity.placeToBuyAddress
    private val placeToBuyId = itemPlaceToBuyEntity.place_to_buy_id
    private var newPlaceToBuyTitle: String? = null
    private var newPlaceToBuyAddress: String? = null

        override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentEditablePlaceToBuyDialogBinding.inflate(
           inflater, container,false)

       binding.dialogPlaceTitleInputTextview.setText(oldPlaceToBuyTitle)
       if (oldPlaceToBuyAddress != null) {
           binding.dialogPlaceAddressInputTextview.setText(oldPlaceToBuyAddress)
       }

       binding.dialogPlaceCancelBtn.setOnClickListener {
           dismiss()
       }

       binding.dialogPlaceSaveBtn.setOnClickListener {
           newPlaceToBuyTitle = binding.dialogPlaceTitleInputTextview.text.toString()
           newPlaceToBuyAddress = binding.dialogPlaceAddressInputTextview.text.toString()
           if (newPlaceToBuyTitle == null) {
               dismiss()
           } else {
               val editedPlaceToBuy = ItemPlaceToBuyEntity(place_to_buy_id = placeToBuyId,
                   placeToBuyName = newPlaceToBuyTitle!!, placeToBuyAddress = newPlaceToBuyAddress)
               updatePlaceToBuyListener.updatePlaceToBuy(editedPlaceToBuy)
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