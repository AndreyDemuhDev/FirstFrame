package com.pidzama.firstframe.network.model.titles

import com.google.gson.annotations.SerializedName


data class Votes (

  @SerializedName("kp"                 ) var kp                 : String? = null,
  @SerializedName("imdb"               ) var imdb               : String? = null,
  @SerializedName("tmdb"               ) var tmdb               : Int?    = null,
  @SerializedName("filmCritics"        ) var filmCritics        : Int?    = null,
  @SerializedName("russianFilmCritics" ) var russianFilmCritics : Int?    = null,
  @SerializedName("await"              ) var await              : Int?    = null

)