package com.pidzama.firstframe.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pidzama.firstframe.network.model.detailItem.Videos
import java.lang.reflect.Type

class VideosConverter {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Videos? {
        if (data == null) {
            return null
        }
        val listType: Type? = object : TypeToken<Videos?>() {}.type
        return gson.fromJson<Videos?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Videos?): String? {
        return gson.toJson(someObjects)
    }
}