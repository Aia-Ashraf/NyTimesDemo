package com.example.nytimes.presentation.view

import com.example.nytimes.data.models.NewsList

interface NYView {
    fun setData(list: MutableList<NewsList>)
}