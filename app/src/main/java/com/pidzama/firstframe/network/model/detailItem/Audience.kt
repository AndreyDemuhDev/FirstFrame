package com.pidzama.firstframe.network.model.detailItem

import com.google.gson.annotations.SerializedName


data class Audience (

  @SerializedName("count"   ) var count   : Int?    = null,
  @SerializedName("country" ) var country : String? = null

)