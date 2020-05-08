package com.example.nytimes.data.models

import com.example.nytimes.data.models.NewsList


data class Response (

    val status : String,
    val copyright : String,
    var results : MutableList<NewsList>
)