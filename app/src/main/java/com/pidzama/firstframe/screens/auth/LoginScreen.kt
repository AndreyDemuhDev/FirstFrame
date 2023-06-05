package com.pidzama.firstframe.screens.auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.tooling.preview.Preview
import com.pidzama.firstframe.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pidzama.firstframe.navigation.AuthScreen
import com.pidzama.firstframe.navigation.Graph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val checkedState = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo image",
                modifier = Modifier.size(200.dp).padding(top = 20.dp)
            )
            Text(
                text = stringResource(R.string.enter_account),
                fontSize = 40.sp
            )
            OutlinedTextField(
                value = login.value,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface),
                onValueChange = { login.value = it },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_login_account),
                        contentDescription = "login logo"
                    )
                },
                label = { Text(stringResource(R.string.enter_login)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { }
                )
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_password_lock),
                        contentDescription = "password logo"
                    )
                },
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                label = { Text(text = stringResource(id = R.string.enter_password)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { navController.navigate(AuthScreen.Forgot.route) },
                text = stringResource(id = R.string.forgot_password),
                color = Color.Gray
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                val enabledCheckBox = login.value.isNotEmpty() && password.value.isNotEmpty()
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    enabled = enabledCheckBox
                )
                Text(text = stringResource(R.string.remember_me))
            }
            Button(onClick = {
                navController.popBackStack()
                navController.navigate(Graph.HOME)
            }) {
                Text(
                    text = stringResource(R.string.Login),
                    modifier = Modifier.padding(horizontal = 60.dp)
                )
            }
            OutlinedButton(
                onClick = { navController.navigate(AuthScreen.SignUp.route) }
            ) {
                Text(
                    text = stringResource(R.string.Sign_up),
                    modifier = Modifier.padding(horizontal = 60.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewScreen() {
    LoginScreen(navController = rememberNavController())
}