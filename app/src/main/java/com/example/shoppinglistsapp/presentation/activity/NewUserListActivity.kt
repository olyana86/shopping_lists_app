package com.example.shoppinglistsapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.shoppinglistsapp.R

lateinit var listTitleEditText: EditText
lateinit var readyBtn: Button
lateinit var manageListBtn: Button


class NewUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user_list)
    }
}