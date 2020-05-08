package com.example.nytimes.data.models

import com.google.gson.annotations.SerializedName


data class NewsList (

	val uri : String,
	val url : String,
	val id : Double,
	val source : String,
	@SerializedName ("published_date")
	val publishedDate : String,
	val updated : String,
	val section : String,
	val subsection : String,
	val nytdsection : String,
	val column : String,
	val byline : String,
	val type : String,
	val title : String="",
	val abstract : String = "",
	val media : List<Media>
)