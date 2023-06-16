package com.pidzama.firstframe.network.model.titles

import com.google.gson.annotations.SerializedName


data class SeasonsInfo (

  @SerializedName("number"        ) var number        : Int? = null,
  @SerializedName("episodesCount" ) var episodesCount : Int? = null

)