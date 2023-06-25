package com.pidzama.firstframe.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pidzama.firstframe.network.model.detailItem.Rating
import java.lang.reflect.Type

class RatingConverter {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Rating? {
        if (data == null) {
            return null
        }
        val listType: Type? = object : TypeToken<Rating?>() {}.type
        return gson.fromJson<Rating?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Rating?): String? {
        return gson.toJson(someObjects)
    }
}