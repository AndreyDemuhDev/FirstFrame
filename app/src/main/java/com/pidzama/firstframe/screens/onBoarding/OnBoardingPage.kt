package com.pidzama.firstframe.screens.onBoarding

import androidx.annotation.DrawableRes
import com.pidzama.firstframe.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.ic_launcher_foreground,
        title = "1 экран",
        description = "Описание 1 экрана"
    )

    object Second : OnBoardingPage(
        image = R.drawable.ic_launcher_foreground,
        title = "2 экран",
        description = "Описание 2 экрана"
    )

    object Third : OnBoardingPage(
        image = R.drawable.ic_launcher_foreground,
        title = "3 экран",
        description = "Описание 3 экрана"
    )
}
