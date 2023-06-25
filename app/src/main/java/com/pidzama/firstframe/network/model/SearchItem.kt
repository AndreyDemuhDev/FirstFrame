package com.pidzama.firstframe.network.model

data class SearchItem(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)

data class Doc(

    val countries: List<String>,
    val genres: List<String>,
    val id: Int,
    val name: String,
    val poster: String,
    val rating: Double,
    val year: Int
)