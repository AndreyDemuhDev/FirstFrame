package com.pidzama.firstframe.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.NoPhotography
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pidzama.firstframe.R
import com.pidzama.firstframe.navigation.DetailScreen
import com.pidzama.firstframe.network.model.Doc
import com.pidzama.firstframe.screens.home.viewModel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController = rememberNavController()) {

    val viewModel = hiltViewModel<SearchViewModel>()
    val query: MutableState<String> = remember { mutableStateOf("") }
    val result = viewModel.searchList.value
    var active by remember {
        mutableStateOf(false)
    }
    val itemsSearch = remember {
        mutableSetOf<String>()
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(6.dp)) {
            SearchBar(
                query = query.value,
                onQueryChange = {
                    query.value = it
                    viewModel.searchTitle(query.value)
                },
                onSearch = {
                    itemsSearch.add(query.value)
                    active = false
                    query.value = query.value
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = { Text(text = "Search") },
                enabled = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                },
                trailingIcon = {
                    if (active) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (query.value.isNotEmpty()) {
                                    query.value = ""
                                } else {
                                    active = false
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "close icon"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsSearch.forEach {
                    Row(modifier = Modifier.padding(all = 14.dp)) {
                        Icon(
                            modifier = Modifier.padding(end = 10.dp),
                            imageVector = Icons.Default.History,
                            contentDescription = "history icon"
                        )
                        Text(
                            modifier = Modifier.clickable { query.value = it },
                            text = it
                        )
                    }
                }
            }

            if (result.isLoading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            if (result.error.isNotBlank()) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = viewModel.searchList.value.error
                    )
                }
            }

            if (result.data.isNotEmpty()) {
                LazyColumn(modifier = Modifier.padding(bottom = 50.dp)) {
                    viewModel.searchList.value.data.let { title ->
                        items(title) {
                            SearchCardItem(title = it, navController = navController)
                        }
                    }
                }
            }
            if (result.data.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = "search icon",
                        modifier = Modifier
                            .size(60.dp),
                    )
                    Text(
                        text = "Введите запрос для поиска",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}

@Composable
fun SearchCardItem(title: Doc, navController: NavHostController) {
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
                if (title.poster != null) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(title.poster)
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
                    text = title.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = title.genres.take(2).toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
                Row() {
                    title.countries.forEach { countrie ->
                        Text(
                            text = countrie,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
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
                    val rating = title.rating
                    Text(
                        text = String.format("%.1f", rating),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}