package com.pidzama.firstframe.screens.home.tabScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pidzama.firstframe.navigation.DetailScreen
import com.pidzama.firstframe.network.model.titles.Docs
import com.pidzama.firstframe.screens.home.viewModel.AnimeViewModel

@Composable
fun AnimeScreen(navController: NavHostController = rememberNavController()) {
    val viewModel = hiltViewModel<AnimeViewModel>()
    val listAnimes = viewModel.allAnime.observeAsState(listOf()).value
    val listTopAnimes = viewModel.topAnime.observeAsState(listOf()).value
    val listComingSoonAnimes = viewModel.comingSoonAnime.observeAsState(listOf()).value
    viewModel.getAllAnime()
    viewModel.getTopAnime()
    viewModel.getComingSoonAnime()

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
            item {
                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Anime screen")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listAnimes.take(6)) { item ->
                                ListAllAnime(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Top Animes")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listTopAnimes.take(6)) { item ->
                                ListAnime(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Coming Soon Anime")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listComingSoonAnimes.take(6)) { item ->
                                ListAnime(movie = item, navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListAllAnime(movie: Docs, navController: NavHostController) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(260.dp)
            .clickable { },
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(movie.poster?.url)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ListAnime(movie: Docs, navController: NavHostController) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(260.dp)
            .clickable { navController.navigate(DetailScreen.DetailTitle.route + "/${movie.id.toString()}") },
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(movie.poster?.url)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}