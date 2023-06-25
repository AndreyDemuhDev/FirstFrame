package com.pidzama.firstframe.network.model.detailItem

import androidx.room.*
import com.google.gson.annotations.SerializedName

//класс данных который содержит информацию о конкретном тайтле
@Entity(tableName = "title_table")
data class DetailItem(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("year")
    var year: Int? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("rating")
    @TypeConverters
    var rating: Rating? = Rating(),
    @SerializedName("movieLength")
    var movieLength: Int? = null,
    @SerializedName("ageRating")
    var ageRating: Int? = null,
    @SerializedName("poster")
    @Embedded(prefix = "poster")
    var poster: Poster? = Poster(),
    @SerializedName("videos")
    @TypeConverters
    var videos: Videos? = Videos(),
    @SerializedName("genres")
    @TypeConverters
    var genres: ArrayList<Genres> = arrayListOf(),
    @SerializedName("persons")
    @TypeConverters
    var persons: ArrayList<Persons> = arrayListOf(),
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)

data class Genres(
    @SerializedName("name")
    var name: String? = null

)

data class Persons(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("photo")
    var photo: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("enName")
    var enName: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("profession")
    var profession: String? = null,
    @SerializedName("enProfession")
    var enProfession: String? = null

)

data class Poster(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("previewUrl")
    var previewUrl: String? = null

)

data class Rating(
    @SerializedName("kp")
    var kp: Double? = null,
    @SerializedName("imdb")
    var imdb: Double? = null,
    @SerializedName("tmdb")
    var tmdb: Double? = null,
    @SerializedName("filmCritics")
    var filmCritics: Double? = null,
    @SerializedName("russianFilmCritics")
    var russianFilmCritics: Double? = null,
    @SerializedName("await")
    var await: Double? = null

)

data class Teasers(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("site")
    var site: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("size")
    var size: Int? = null

)

data class Trailers(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("site")
    var site: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("size")
    var size: Int? = null

)

data class Videos(
    @SerializedName("trailers")
    var trailers: ArrayList<Trailers> = arrayListOf(),
    @SerializedName("teasers")
    var teasers: ArrayList<Teasers> = arrayListOf()

)