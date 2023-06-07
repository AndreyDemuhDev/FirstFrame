package com.pidzama.firstframe.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pidzama.firstframe.R
import com.pidzama.firstframe.navigation.AuthScreen
import com.pidzama.firstframe.navigation.Graph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotScreen(
    navController: NavHostController
) {
    val email = remember { mutableStateOf("") }

    Card(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.splash_logo),
                contentDescription = "logo image",
                modifier = Modifier
                    .size(200.dp)
                    .padding(top = 20.dp)
            )
            Text(
                text = stringResource(R.string.forgot_screen),
                textAlign = TextAlign.Center,
                fontSize = 34.sp,
                style = MaterialTheme.typography.displayMedium
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                value = email.value,
                onValueChange = { email.value = it },
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(R.string.enter_email)) },
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_email),
                        contentDescription = "email logo"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(top = 40.dp),
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }) {
                Text(
                    text = stringResource(R.string.Login),
                    modifier = Modifier.padding(horizontal = 60.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    ForgotScreen(navController = rememberNavController())
}