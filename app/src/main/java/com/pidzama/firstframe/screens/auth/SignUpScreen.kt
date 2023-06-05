package com.pidzama.firstframe.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
fun SignUpScreen(
    navController: NavHostController
) {
    val login = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Card(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo image",
                modifier = Modifier.size(200.dp).padding(top = 20.dp)
            )
            Text(
                text = stringResource(R.string.create_account),
                fontSize = 40.sp
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                value = login.value,
                onValueChange = { login.value = it },
                label = { Text(text = stringResource(id = R.string.enter_login)) },
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_login_account),
                        contentDescription = "login logo"
                    )
                },
                keyboardActions = KeyboardActions(
                    onDone = { }
                )
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text(text = stringResource(id = R.string.enter_email)) },
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = "email logo"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onDone = { }
                )
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = stringResource(R.string.enter_password)) },
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_password_lock),
                        contentDescription = "password logo"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { }
                )
            )
            Button(onClick = {
                navController.popBackStack()
                navController.navigate(Graph.HOME)
            }) {
                Text(
                    text = stringResource(R.string.Sign_up),
                    modifier = Modifier.padding(horizontal = 60.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun previewScreen() {
    SignUpScreen(navController = rememberNavController())
}