package com.pidzama.firstframe.network.model

import com.google.gson.annotations.SerializedName

data class DetailPerson(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("photo")
    var photo: String? = null,
    @SerializedName("birthday")
    var birthday: String? = null,
    @SerializedName("death")
    var death: String? = null,
    @SerializedName("age")
    var age: Int? = null,
    @SerializedName("birthPlace")
    var birthPlace: ArrayList<BirthPlace> = arrayListOf(),
    @SerializedName("deathPlace")
    var deathPlace: ArrayList<DeathPlace> = arrayListOf(),
    @SerializedName("profession")
    var profession: ArrayList<Profession> = arrayListOf(),
    )

data class BirthPlace(
    @SerializedName("value")
    var value: String? = null
)

data class DeathPlace(
    @SerializedName("value")
    var value: String? = null
)

data class Profession(
    @SerializedName("value")
    var value: String? = null
)