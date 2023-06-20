package com.pidzama.firstframe.network.model.search

data class Doc(
    val alternativeName: String,
    val backdrop: String,
    val countries: List<String>,
    val description: String,
    val enName: String,
    val genres: List<String>,
    val id: Int,
    val logo: String,
    val movieLength: Int,
    val name: String,
    val names: List<String>,
    val poster: String,
    val rating: Double,
    val releaseYears: List<Any>,
    val shortDescription: String,
    val type: String,
    val votes: Int,
    val year: Int
)