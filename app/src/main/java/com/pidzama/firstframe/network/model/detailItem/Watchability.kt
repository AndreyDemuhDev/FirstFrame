package com.pidzama.firstframe.network.model.detailItem

import com.google.gson.annotations.SerializedName


data class Watchability (

  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf()

)