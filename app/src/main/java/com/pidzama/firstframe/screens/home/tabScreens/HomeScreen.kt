package com.pidzama.firstframe.screens.home.tabScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
import com.pidzama.firstframe.navigation.DetailScreen
import com.pidzama.firstframe.network.model.Docs
import com.pidzama.firstframe.screens.home.viewModel.MovieViewModel

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val viewModel = hiltViewModel<MovieViewModel>()
    val listAllMovie = viewModel.allMovies.observeAsState(listOf()).value
    val listTopMovie = viewModel.topMovies.observeAsState(listOf()).value
    val listComingSoonMovie = viewModel.comingSoonMovies.observeAsState(listOf()).value
    viewModel.getAllMovies()
    viewModel.getTopMovies()
    viewModel.getComingSoonMovies()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
        ) {
            item {
                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Movies screen")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyRow(
                        modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                    ) {
                        items(listAllMovie.take(6)) { item ->
                            ListAllMovies(movie = item, navController = navController)
                        }
                    }
                    Text(text = "Top Movies")
                    LazyRow(
                        modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                    ) {
                        items(listTopMovie) { item ->
                            ListMovies(movie = item, navController = navController)
                        }
                    }
                    Text(text = "Coming Soon Movies")
                    LazyRow(
                        modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                    ) {
                        items(listComingSoonMovie.take(6)) { item ->
                            ListMovies(movie = item, navController = navController)
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

@Composable
fun ListMovies(movie: Docs, navController: NavHostController) {
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