package com.pidzama.firstframe.network.model.detailPerson

import com.google.gson.annotations.SerializedName


data class DetailPerson (

    @SerializedName("id"          ) var id          : Int?                  = null,
    @SerializedName("name"        ) var name        : String?               = null,
    @SerializedName("enName"      ) var enName      : String?               = null,
    @SerializedName("photo"       ) var photo       : String?               = null,
    @SerializedName("sex"         ) var sex         : String?               = null,
    @SerializedName("growth"      ) var growth      : Int?                  = null,
    @SerializedName("birthday"    ) var birthday    : String?               = null,
    @SerializedName("death"       ) var death       : String?               = null,
    @SerializedName("age"         ) var age         : Int?                  = null,
    @SerializedName("birthPlace"  ) var birthPlace  : ArrayList<BirthPlace> = arrayListOf(),
    @SerializedName("deathPlace"  ) var deathPlace  : ArrayList<DeathPlace> = arrayListOf(),
    @SerializedName("spouses"     ) var spouses     : ArrayList<Spouses?>   = arrayListOf(),
    @SerializedName("countAwards" ) var countAwards : Int?                  = null,
    @SerializedName("profession"  ) var profession  : ArrayList<Profession> = arrayListOf(),
    @SerializedName("facts"       ) var facts       : ArrayList<Facts>      = arrayListOf(),
    @SerializedName("movies"      ) var movies      : ArrayList<Movies>     = arrayListOf()

)