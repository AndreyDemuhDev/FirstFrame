package com.pidzama.firstframe.network.model.titles

import com.google.gson.annotations.SerializedName


data class World (

  @SerializedName("value"    ) var value    : Int?    = null,
  @SerializedName("currency" ) var currency : String? = null

)