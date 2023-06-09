package com.pidzama.firstframe.screens

import androidx.compose.runtime.Composable
import com.pidzama.firstframe.utils.Constants.TabScreens.ANIME
import com.pidzama.firstframe.utils.Constants.TabScreens.CARTOON
import com.pidzama.firstframe.utils.Constants.TabScreens.FILMS
import com.pidzama.firstframe.utils.Constants.TabScreens.MULTSERIALS
import com.pidzama.firstframe.utils.Constants.TabScreens.TV_SERIES
import com.pidzama.firstframe.utils.Constants.TabScreens.TV_SHOW

typealias ComposableFun = @Composable () -> Unit
sealed class TabScreens(var title: String, var screen: ComposableFun){

    object Films: TabScreens(FILMS, {  })
    object Series: TabScreens(TV_SERIES, {  })
    object Cartoon: TabScreens(CARTOON, {  })
    object Anime: TabScreens(ANIME, {  })
    object Multserials: TabScreens(MULTSERIALS, { })
    object TVshows: TabScreens(TV_SHOW, { })

}
