package com.pidzama.firstframe.screens

import androidx.compose.runtime.Composable
import com.pidzama.firstframe.screens.home.tabScreens.HomeScreen
import com.pidzama.firstframe.screens.home.TvSeriesScreen
import com.pidzama.firstframe.screens.home.tabScreens.AnimeScreen
import com.pidzama.firstframe.screens.home.tabScreens.CartoonScreen
import com.pidzama.firstframe.screens.home.tabScreens.MultserialsScreen
import com.pidzama.firstframe.utils.Constants.TabScreens.ANIME
import com.pidzama.firstframe.utils.Constants.TabScreens.CARTOON
import com.pidzama.firstframe.utils.Constants.TabScreens.FILMS
import com.pidzama.firstframe.utils.Constants.TabScreens.MULTSERIALS
import com.pidzama.firstframe.utils.Constants.TabScreens.TV_SERIES

typealias ComposableFun = @Composable () -> Unit

sealed class TabScreens(var title: String, var screen: ComposableFun) {

    object Films : TabScreens(FILMS, { HomeScreen() })
    object Series : TabScreens(TV_SERIES, { TvSeriesScreen() })
    object Cartoon : TabScreens(CARTOON, { CartoonScreen() })
    object Anime : TabScreens(ANIME, { AnimeScreen() })
    object Multserials : TabScreens(MULTSERIALS, { MultserialsScreen() })

}
