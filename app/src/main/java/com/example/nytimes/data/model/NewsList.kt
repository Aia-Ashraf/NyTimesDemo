package com.example.nytimes


data class NewsList (

	val uri : String,
	val url : String,
	val id : Double,
	val asset_id : Double,
	val source : String,
	val published_date : String,
	val updated : String,
	val section : String,
	val subsection : String,
	val nytdsection : String,
	val adx_adx_keywordswords : String,
	val column : String,
	val byline : String,
	val type : String,
	val title : String,
	val abstract : String,
	val des_facet : List<String>,
	val org_facet : List<String>,
	val per_facet : List<String>,
	val geo_facet : List<String>,
	val media : List<Media>,
	val eta_id : Int
)