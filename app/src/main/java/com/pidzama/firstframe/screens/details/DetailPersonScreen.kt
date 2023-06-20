package com.pidzama.firstframe.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.pidzama.firstframe.R
import com.pidzama.firstframe.utils.DateFormater

@Composable
fun DetailPersonScreen(id: String, navController: NavHostController) {

    val viewModel = hiltViewModel<DetailViewModel>()
    val currentPerson = viewModel.detailPerson.observeAsState().value
    viewModel.getDetailPerson(id)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface.copy(0.2f)),
                        onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_button_back),
                            contentDescription = "button back"
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 15.dp),
                        text = currentPerson?.name.toString(),
                        style = MaterialTheme.typography.headlineSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = false,
                        textAlign = TextAlign.Center
                    )
                }
                Card(
                    modifier = Modifier
                        .size(width = 340.dp, height = 450.dp),
                    border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.primary),
                    shape = MaterialTheme.shapes.large
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = currentPerson?.photo, contentDescription = "person photo",
                        contentScale = ContentScale.Crop,
                    )
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        currentPerson?.profession?.forEach { prof ->
                            Text(
                                text = "${prof.value} ",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Birthday: ",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        DateFormater(currentPerson?.birthday.toString())?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Place birthday: ",
                            style = MaterialTheme.typography.titleMedium
                        )
                        currentPerson?.birthPlace?.forEach {
                            Text(text = it.value.toString() + " ")
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Age: ",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = currentPerson?.age.toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    if (currentPerson?.death != null) {
                        Text(text = "Death: " + currentPerson.death)
                        Text(text = "Death birthday: " + currentPerson.deathPlace)
                    }
                }
            }
        }
    }
}