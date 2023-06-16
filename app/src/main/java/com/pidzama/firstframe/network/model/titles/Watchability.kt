package com.pidzama.firstframe.network.model.titles

import com.google.gson.annotations.SerializedName


data class Watchability (

  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf()

)