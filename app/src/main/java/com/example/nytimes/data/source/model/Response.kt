package com.example.nytimes



data class Response (

    val status : String,
    val copyright : String,
    val num_results : Int,
    var results : MutableList<NewsList>
)