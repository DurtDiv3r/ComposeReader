package com.example.composereader.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyUI() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF36003C), Color(0xFF702776))
                )
            )
    ) {
    }
}

@Composable
fun UsernameInputForm(
    modifier: Modifier = Modifier,
    usernameLabel: String = "Username",
    usernameState: MutableState<String>,
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    InputField(
        modifier = modifier,
        label = usernameLabel,
        inputState = usernameState,
        enabled = enabled,
        imeAction = imeAction,
        onAction = onAction,
        keyboardType = KeyboardType.Email
    )
}

@Composable
fun EmailInputForm(
    modifier: Modifier = Modifier,
    emailLabel: String = "Email",
    emailState: MutableState<String>,
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    InputField(
        modifier = modifier,
        label = emailLabel,
        inputState = emailState,
        enabled = enabled,
        imeAction = imeAction,
        onAction = onAction,
        keyboardType = KeyboardType.Email
    )
}

@Composable
fun PasswordInputForm(
    modifier: Modifier,
    passwordLabel: String = "Password",
    passwordState: MutableState<String>,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    val visualTransformation = if (passwordVisibility.value) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { state ->
            passwordState.value = state
        },
        label = {
            Text(text = passwordLabel)
        },
        singleLine = true,
        textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            PasswordVisibility(passwordVisibility = passwordVisibility)
        },
        keyboardActions = onAction
    )
}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
    val isVisible = passwordVisibility.value

    IconButton(onClick = {
        passwordVisibility.value = !isVisible
    }) {
        Icons.Default.Close
    }
}

fun onDone(username: String, email: String, password: String) {
    TODO("Not yet implemented")
}


@Composable
fun InputField(
    modifier: Modifier = Modifier,
    label: String,
    inputState: MutableState<String>,
    enabled: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {

    OutlinedTextField(
        value = inputState.value,
        onValueChange = { state ->
            inputState.value = state
        },
        label = {
            Text(text = label)
        },
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction)
    )
}

@Composable
fun SubmitButton(label: String,
                 loading: Boolean,
                 valid: Boolean,
                 onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier
        .padding(50.dp)
        .fillMaxWidth(), enabled = !loading && valid, shape = CircleShape) {
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp)) else Text(text = label)
    }
}
