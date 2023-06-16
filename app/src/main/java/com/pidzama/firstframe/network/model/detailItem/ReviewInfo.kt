package com.pidzama.firstframe.network.model.detailItem

import com.google.gson.annotations.SerializedName


data class ReviewInfo (

  @SerializedName("count"         ) var count         : Int?    = null,
  @SerializedName("positiveCount" ) var positiveCount : Int?    = null,
  @SerializedName("percentage"    ) var percentage    : String? = null

)