package com.pidzama.firstframe.utils

class Constants {

    object TabScreens {
        const val FILMS = "Films"
        const val TV_SERIES = "Serials"
        const val CARTOON = "Cartoon"
        const val ANIME = "Anime"
        const val MULTSERIALS = "Multserials"
    }

    companion object {
        const val BASE_URL = "https://api.kinopoisk.dev/"
        const val TOKEN = "189ZY1V-VF9MPKM-PE65YZD-6M2VRDF"
    }

    object DataStorePreference {
        const val ONBOARDING_KEY = "on_boarding_completed"
        const val FAVORITE = "favorite_title"
    }
}