package com.pidzama.firstframe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.pidzama.firstframe.navigation.RootNavGraph
import com.pidzama.firstframe.screens.onBoarding.SplashScreenViewModel
import com.pidzama.firstframe.ui.theme.FirstFrameTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashScreenViewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !splashScreenViewModel.isLoading.value
        }

        setContent {
            FirstFrameTheme {
                val startScreen by splashScreenViewModel.startDestination
                RootNavGraph(
                    navController = rememberNavController(),
                    startDestination = startScreen
                )
            }
        }
    }
}
