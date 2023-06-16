package com.pidzama.firstframe.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.pidzama.firstframe.R
import com.pidzama.firstframe.navigation.DetailScreen
import com.pidzama.firstframe.network.model.detailItem.Persons
import com.pidzama.firstframe.utils.timeToString

@Composable
fun DetailsScreen(id: String, navController: NavHostController) {

    val viewModel = hiltViewModel<DetailViewModel>()
    val currentTitle = viewModel.detailTitle.observeAsState().value
    val currentCast = viewModel.listCast.observeAsState(listOf()).value
    viewModel.getDetailTitle(id)
    viewModel.getListPersons(id)

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(470.dp)
                            .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                    ) {
                        AsyncImage(
                            modifier = Modifier.fillMaxSize(),
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(currentTitle?.poster?.url)
                                .crossfade(true)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 20.dp, start = 15.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(modifier = Modifier
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surface.copy(0.2f)),
                            onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_button_back),
                                contentDescription = "buttonBack"
                            )
                        }
                        IconButton(modifier = Modifier
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surface.copy(0.2f)),
                            onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_favorite),
                                contentDescription = "buttonFavorite"
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .background(MaterialTheme.colorScheme.surface.copy(0.4f))
                            .align(Alignment.BottomCenter)
                            .size(width = 150.dp, height = 40.dp)
                            .clip(shape = MaterialTheme.shapes.large),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,

                        ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(R.drawable.ic_play),
                            contentDescription = "play button"
                        )
                        Text(
                            text = "Watch trailer",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = currentTitle?.name.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Row() {
                        currentTitle?.genres?.take(2)?.forEach { genre ->
                            Text(
                                text = "${genre.name} ",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.padding(top = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        currentTitle?.rating?.imdb?.toFloat()?.let {
                            RatingBar(
                                config = RatingBarConfig().size(23.dp),
                                value = it / 2f,
                                onValueChange = {},
                                onRatingChanged = {})
                        }
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = currentTitle?.rating?.imdb.toString(),
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                    Row(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Card(
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                            shape = MaterialTheme.shapes.large
                        ) {
                            Text(
                                text = currentTitle?.year.toString(),
                                modifier = Modifier
                                    .padding(all = 5.dp)
                                    .size(width = 50.dp, height = 20.dp),
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                        Card(
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                            shape = MaterialTheme.shapes.large
                        ) {
                            Text(
                                text = currentTitle?.movieLength?.let { timeToString(it) }
                                    .toString(),
                                modifier = Modifier
                                    .padding(all = 5.dp)
                                    .size(width = 70.dp, height = 20.dp),
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                        Card(
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                            shape = MaterialTheme.shapes.extraLarge
                        ) {
                            Text(
                                text = currentTitle?.ageRating.toString() + "+",
                                modifier = Modifier
                                    .padding(all = 5.dp)
                                    .size(width = 50.dp, height = 20.dp),
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        textAlign = TextAlign.Justify,
                        text = currentTitle?.description.toString(),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .background(Color.Gray)
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 8.dp),
                        text = "Cast",
                        style = MaterialTheme.typography.titleLarge
                    )
                    LazyRow() {
                        items(currentCast) {
                            ListCast(person = it, navController = navController)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ListCast(person: Persons, navController :NavHostController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .size(100.dp)
            .clickable { navController.navigate(DetailScreen.DetailPerson.route + "/${person.id}") }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = person.photo,
            contentScale = ContentScale.Crop,
            contentDescription = "img_star",
        )
    }
}
