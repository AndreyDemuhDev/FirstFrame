package com.pidzama.firstframe.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pidzama.firstframe.network.model.detailItem.Genres
import kotlin.collections.ArrayList

class GenresConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): ArrayList<Genres?>? {
        if (data == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<Genres?>?>() {}.type
        return gson.fromJson<ArrayList<Genres?>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: ArrayList<Genres?>?): String? {
        return gson.toJson(someObjects)
    }
}