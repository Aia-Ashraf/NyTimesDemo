package com.example.nytimes.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytimes.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val intent = intent
        val title: String = intent.getStringExtra("title")
        val description: String = intent.getStringExtra("des")

        tv_details_description.text =description
        tv_details_title.text =title
    }
}
