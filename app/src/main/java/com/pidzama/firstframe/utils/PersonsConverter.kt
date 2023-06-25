package com.pidzama.firstframe.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pidzama.firstframe.network.model.detailItem.Persons
import kotlin.collections.ArrayList

class PersonsConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): ArrayList<Persons?>? {
        if (data == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<Persons?>?>() {}.type
        return gson.fromJson<ArrayList<Persons?>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: ArrayList<Persons?>?): String? {
        return gson.toJson(someObjects)
    }
}