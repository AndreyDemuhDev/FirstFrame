package com.pidzama.firstframe.network.model.detailItem

import com.google.gson.annotations.SerializedName


data class ImagesInfo (

  @SerializedName("postersCount"   ) var postersCount   : Int? = null,
  @SerializedName("backdropsCount" ) var backdropsCount : Int? = null,
  @SerializedName("framesCount"    ) var framesCount    : Int? = null

)