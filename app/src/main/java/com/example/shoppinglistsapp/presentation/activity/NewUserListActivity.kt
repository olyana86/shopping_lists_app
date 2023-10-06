package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistsapp.R
import com.example.shoppinglistsapp.databinding.ActivityNewUserListBinding

class NewUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewUserListBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_user_list)
    }
}