package com.pidzama.firstframe.network.model

import com.google.gson.annotations.SerializedName


data class ReleaseYears (

  @SerializedName("start" ) var start : Int? = null,
  @SerializedName("end"   ) var end   : Int? = null

)