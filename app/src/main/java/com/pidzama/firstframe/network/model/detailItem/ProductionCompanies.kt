package com.pidzama.firstframe.network.model.detailItem

import com.google.gson.annotations.SerializedName


data class ProductionCompanies (

  @SerializedName("name"       ) var name       : String? = null,
  @SerializedName("url"        ) var url        : String? = null,
  @SerializedName("previewUrl" ) var previewUrl : String? = null

)