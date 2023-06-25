package com.pidzama.firstframe.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NoPhotography
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pidzama.firstframe.R
import com.pidzama.firstframe.navigation.DetailScreen
import com.pidzama.firstframe.network.model.detailItem.DetailItem
import com.pidzama.firstframe.screens.home.viewModel.FavoriteViewModel

@Composable
fun FavoriteScreen(navController: NavHostController = rememberNavController()) {

    val viewModel = hiltViewModel<FavoriteViewModel>()
    val listFavoriteTitles = viewModel.listFavoriteTitles.collectAsState(initial = emptyList())

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Your Favorite Movies",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )
            if (listFavoriteTitles.value.isEmpty()) {
                Image(
                    painter = painterResource(R.drawable.empty_package),
                    contentDescription = "empty package image",
                    modifier = Modifier
                        .fillMaxSize()
                        .size(width = 150.dp, height = 80.dp),
                    alignment = Alignment.Center
                )
            }
            if (listFavoriteTitles.value.isNotEmpty()) {
                LazyColumn(modifier = Modifier.padding(bottom = 50.dp)) {
                    items(listFavoriteTitles.value) { title ->
                        FavoriteItem(title = title, navController = navController)
                    }
                }
            }
        }
    }
}


@Composable
fun FavoriteItem(title: DetailItem, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(180.dp)
            .clickable { navController.navigate(DetailScreen.DetailTitle.route + "/${title.id}") },
        shape = MaterialTheme.shapes.extraLarge,
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)
    ) {
        Row() {
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
            ) {
                if (title.poster?.url != null) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(title.poster?.previewUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.NoPhotography, contentDescription = "no photo",
                        modifier = Modifier.fillMaxSize()

                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = title.name.toString(),
                    style = MaterialTheme.typography.titleLarge
                )
                Row {
                    val listGenres = title.genres.map { it.name }
                    Text(text = listGenres.take(3).joinToString(separator = ", "))
                }
                Text(
                    text = title.year.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.ic_rating_star),
                        contentDescription = "rating",
                        tint = Color.Yellow
                    )
                    val rating = title.rating?.imdb
                    Text(
                        text = String.format("%.1f", rating),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}