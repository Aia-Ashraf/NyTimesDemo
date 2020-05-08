package com.example.nytimes.presentation.view

import com.example.nytimes.NewsList

interface NYView {
    fun setData(list: MutableList<NewsList>)
}