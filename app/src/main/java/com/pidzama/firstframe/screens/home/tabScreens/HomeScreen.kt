package com.pidzama.firstframe.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
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
import com.pidzama.firstframe.network.model.Docs
import com.pidzama.firstframe.screens.home.viewModel.MovieViewModel

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val viewModel = hiltViewModel<MovieViewModel>()
    val listAllMovie = viewModel.allMovies.observeAsState(listOf()).value
    viewModel.getAllMovies()

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
            item {
                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Movies screen")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listAllMovie.take(2)) { item ->
                                ListAllMovies(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Coming Soon Movies")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listAllMovie.take(2)) { item ->
                                ListMovies(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Top Movies")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listAllMovie.take(2)) { item ->
                                ListMovies(movie = item, navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListAllMovies(movie: Docs, navController: NavHostController) {
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
fun ListMovies(movie: Docs, navController: NavHostController) {
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