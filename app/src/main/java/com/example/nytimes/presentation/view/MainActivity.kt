package com.example.nytimes.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.NYViewModel
import com.example.nytimes.NewsList
import com.example.nytimes.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NYView {

     lateinit var nyAdapter: NyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(NYViewModel::class.java)
        viewModel.getNyNews()
        initRecyclerView()
        nyAdapter = NyAdapter(this)
        viewModel.nyView = this
        rv_ny_news.adapter = nyAdapter
    }

    private fun initRecyclerView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager
        rv_ny_news.layoutManager = layoutManager
        rv_ny_news.setHasFixedSize(true)
    }
    override fun setData(list: MutableList<NewsList>) {
        nyAdapter?.setNewsList(list!!)
    }
}