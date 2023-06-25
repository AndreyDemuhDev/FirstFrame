package com.pidzama.firstframe.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.pidzama.firstframe.navigation.HomeNavGraph
import com.pidzama.firstframe.screens.BottomBarScreen
import com.pidzama.firstframe.screens.TabScreens
import kotlinx.coroutines.launch
import com.google.accompanist.pager.PagerState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
//        topBar = { TabLayout() }
    ) {
        Column {
            HomeNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.Favorite,
        BottomBarScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomNavigation {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.background,
        ),
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "${screen.title} Icon",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TabLayout() {
    val tabList = listOf(
        TabScreens.Films,
        TabScreens.Series,
        TabScreens.Cartoon,
        TabScreens.Anime,
        TabScreens.Multserials,
    )
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val indicator = @Composable { tabPosition: List<TabPosition> ->
        Indicator(tabPosition, pagerState)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(text = tabList[tabIndex].title)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.tertiary
                ),
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                content = {
                    ScrollableTabRow(
                        modifier = Modifier.height(50.dp),
                        selectedTabIndex = tabIndex,
                        indicator = indicator
                    ) {
                        tabList.forEachIndexed { index, title ->
                            Tab(
                                modifier = Modifier.zIndex(2f),
                                selected = false,
                                unselectedContentColor = MaterialTheme.colorScheme.primary,
                                onClick = {
                                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                                },
                                text = {
                                    Text(
                                        text = title.title,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                }
                            )
                        }
                    }
                    HorizontalPager(
                        modifier = Modifier.fillMaxWidth(),
                        count = tabList.size,
                        state = pagerState,
                    ) { page ->
                        tabList[page].screen()
                    }
                }
            )

        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Indicator(
    tabPositions: List<TabPosition>,
    pagerState: PagerState
) {
    val transition = updateTransition(pagerState.currentPage, label = "")
    val animationStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val animationEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 500f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }
    Box(
        Modifier
            .offset(x = animationStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(animationEnd - animationStart)
            .fillMaxSize()
            .padding(5.dp)
            .background(color = MaterialTheme.colorScheme.surface, RoundedCornerShape(40))
            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.primary), RoundedCornerShape(40))
            .zIndex(0.5f)
    )
}