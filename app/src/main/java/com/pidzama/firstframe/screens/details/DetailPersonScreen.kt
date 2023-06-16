package com.pidzama.firstframe.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun DetailPersonScreen(id: String, navController: NavHostController) {

    val viewModel = hiltViewModel<DetailViewModel>()
    val currentPerson = viewModel.detailPerson.observeAsState().value
    viewModel.getDetailPerson(id)

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = id)
        Text(text = currentPerson?.name.toString())
    }
}