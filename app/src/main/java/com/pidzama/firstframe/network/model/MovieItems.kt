package com.pidzama.firstframe.network.model

import com.google.gson.annotations.SerializedName

//класс данных который отображает список фильмов на домашней странице
data class MovieItems(
    @SerializedName("docs") var docs: ArrayList<Docs> = arrayListOf(),
    @SerializedName("total") var total: Int? = null,
    @SerializedName("limit") var limit: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("pages") var pages: Int? = null
)

data class Docs(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("rating")
    var rating: Rating? = Rating(),
    @SerializedName("year")
    var year: Int? = null,
    @SerializedName("countries")
    var countries: ArrayList<Countries> = arrayListOf(),
    @SerializedName("poster")
    var poster: Poster? = Poster(),
    @SerializedName("genres")
    var genres: ArrayList<Genres> = arrayListOf(),
)

data class Poster(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("previewUrl")
    var previewUrl: String? = null
)

data class Countries(
    @SerializedName("name")
    var name: String? = null
)

data class Genres(
    @SerializedName("name")
    var name: String? = null
)

data class Rating(
    @SerializedName("kp")
    var kp: Double? = null,
    @SerializedName("imdb")
    var imdb: Double? = null,
    @SerializedName("tmdb")
    var filmCritics: Double? = null,
    @SerializedName("russianFilmCritics")
    var russianFilmCritics: Double? = null,
    @SerializedName("await")
    var await: Double? = null
)