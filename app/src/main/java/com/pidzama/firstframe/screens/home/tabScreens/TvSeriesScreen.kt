package com.pidzama.firstframe.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
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
import com.pidzama.firstframe.network.model.Docs
import com.pidzama.firstframe.screens.home.viewModel.TvSeriesViewModel

@Composable
fun TvSeriesScreen(navController: NavHostController = rememberNavController()) {

    val viewModel = hiltViewModel<TvSeriesViewModel>()
    val listTvSeries = viewModel.tvSeries.observeAsState(listOf()).value
    val listTopTvSeries = viewModel.topTvSeries.observeAsState(listOf()).value
    val listComingSoonTvSeries = viewModel.comingSoonTvSeries.observeAsState(listOf()).value
    viewModel.getListTvSeries()
    viewModel.getTopTvSeries()
    viewModel.getComingSoonTvSeries()

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
            item {
                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "TV series screen")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listTvSeries.take(6)) { item ->
                                ListAllTvSeries(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Top Soon TV Series")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listTopTvSeries.take(6)) { item ->
                                ListTvSeries(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Coming Soon  TV series")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listComingSoonTvSeries.take(6)) { item ->
                                ListTvSeries(movie = item, navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListAllTvSeries(movie: Docs, navController: NavHostController) {
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
fun ListTvSeries(movie: Docs, navController: NavHostController) {
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