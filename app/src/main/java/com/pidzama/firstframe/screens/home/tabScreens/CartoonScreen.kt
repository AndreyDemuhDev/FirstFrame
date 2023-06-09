package com.pidzama.firstframe.screens.home.tabScreens

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
import com.pidzama.firstframe.network.model.Docs
import com.pidzama.firstframe.screens.home.viewModel.CartoonViewModel

@Composable
fun CartoonScreen(navController: NavHostController = rememberNavController()){
    val viewModel = hiltViewModel<CartoonViewModel>()
    val listCartoons = viewModel.allCartoons.observeAsState(listOf()).value
    viewModel.getAllCatroons()

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
            item {
                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Cartoon screen")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listCartoons.take(2)) { item ->
                                ListAllCartoons(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Coming Soon Cartoon")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listCartoons.take(2)) { item ->
                                ListCartoons(movie = item, navController = navController)
                            }
                        }
                    }
                    Text(text = "Top Cartoon")
                    Card {
                        LazyRow(
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                        ) {
                            items(listCartoons.take(2)) { item ->
                                ListCartoons(movie = item, navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListAllCartoons(movie: Docs, navController: NavHostController) {
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
fun ListCartoons(movie: Docs, navController: NavHostController) {
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