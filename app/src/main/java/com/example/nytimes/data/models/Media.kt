package com.example.nytimes.data.models



data class Media (

	val type : String,
	val subtype : String,
	val caption : String,
	val copyright : String,
	val mediaMetaData : List<MediaMetaData>
)