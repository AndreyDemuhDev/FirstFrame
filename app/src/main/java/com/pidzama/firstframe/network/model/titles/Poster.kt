package com.pidzama.firstframe.network.model.titles

import com.google.gson.annotations.SerializedName


data class Poster (

  @SerializedName("url"        ) var url        : String? = null,
  @SerializedName("previewUrl" ) var previewUrl : String? = null

)