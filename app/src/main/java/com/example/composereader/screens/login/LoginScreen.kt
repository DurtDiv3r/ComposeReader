package com.example.composereader.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composereader.R.*
import com.example.composereader.components.EmailInputForm
import com.example.composereader.components.MyUI
import com.example.composereader.components.PasswordInputForm
import com.example.composereader.components.SubmitButton

@Composable
fun LoginScreen(navController: NavHostController) {
    MyUI()
    val showLoginForm = rememberSaveable {
        mutableStateOf(true)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp), color = Color.Transparent) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
            if (showLoginForm.value) {
                UserLoginForm(isLoading = false, isCreateAccount = false) { email, password ->
                    //TODO: Firebase Login
                }
            } else {
                UserLoginForm(isLoading = false, isCreateAccount = true) { email, password ->
                    //TODO: Firebase create account
                }
            }

            Spacer(modifier = Modifier.height(60.dp))
            Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.Center) {
                val text = if (showLoginForm.value) "Sign Up" else "Login"

                Text(text = "New User? ")
                Text(text = text, modifier = Modifier
                    .clickable {
                        showLoginForm.value = !showLoginForm.value
                    }
                    .padding(5.dp), fontWeight = FontWeight.Bold, color = MaterialTheme.colors.secondaryVariant)
            }
        }
    }


}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun UserLoginForm(
    isLoading: Boolean = false,
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = { email, password -> }
) {
    val userEmail = rememberSaveable { mutableStateOf("") }
    val userPassword = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val passwordFocus = FocusRequester.Default

    val isValidFormValues = remember(userEmail.value, userPassword.value) {
        userEmail.value.trim().isNotEmpty() && userPassword.value.trim().isNotEmpty()
    }

    val modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.8f)
        .background(Color.Transparent)
        .verticalScroll(
            rememberScrollState()
        )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isCreateAccount) {
            Text(text = stringResource(id = string.login_info), modifier = Modifier.padding(16.dp))
        } else {
            Text(text = "")
        }
        EmailInputForm(emailState = userEmail,
            enabled = !isLoading,
            onAction = KeyboardActions {
                passwordFocus.requestFocus()
            })

        PasswordInputForm(
            modifier = Modifier.focusRequester(passwordFocus),
            passwordState = userPassword,
            enabled = !isLoading,
            passwordVisibility = passwordVisibility,
            onAction = KeyboardActions {
                if (!isValidFormValues) return@KeyboardActions
                onDone(userEmail.value.trim(), userPassword.value.trim())
            })

        SubmitButton(
            label = if (isCreateAccount) "Create Account" else "Login",
            loading = isLoading,
            valid = isValidFormValues
        ) {
            onDone(userEmail.value.trim(), userPassword.value.trim())
            keyboardController?.hide()
        }
    }
}

