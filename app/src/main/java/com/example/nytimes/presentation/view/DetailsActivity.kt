package com.example.nytimes.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytimes.R
import kotlinx.android.synthetic.main.activity_details.*
import android.app.PendingIntent.getActivity


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.nytimes.R.layout.activity_details)
        this.getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getData()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getData() {
        val intent = intent
        if (intent.extras !=null){
        val title: String = intent.getStringExtra("title")
        val description: String = intent.getStringExtra("des")
        bindData(description, title)
    }}

    private fun bindData(description: String, title: String) {
        tv_details_description.text = description
        tv_details_title.text = title
    }
}
