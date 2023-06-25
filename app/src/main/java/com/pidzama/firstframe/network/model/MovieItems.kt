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
    @SerializedName("poster")
    var poster: Poster? = Poster(),
)

data class Poster(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("previewUrl")
    var previewUrl: String? = null
)