package com.example.nytimes



data class Media (

	val type : String,
	val subtype : String,
	val caption : String,
	val copyright : String,
	val approved_for_syndication : Int,
	val mediaMetaData : List<MediaMetaData>
)