package com.pidzama.firstframe.network.model

import com.google.gson.annotations.SerializedName


data class Watchability (

  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf()

)