package com.pidzama.firstframe.network.model.search

data class SearchItem(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)