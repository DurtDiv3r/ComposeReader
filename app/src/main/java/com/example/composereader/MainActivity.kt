package com.example.composereader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composereader.components.MyUI
import com.example.composereader.navigation.AppNavigation
import com.example.composereader.ui.theme.ComposeReaderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeReaderTheme {
                //Initial setup of FireStore... Add test user
//                val db = FirebaseFirestore.getInstance()
//                val user: MutableMap<String, Any> = HashMap()
//
//                user["firstName"] = "Bob"
//                user["lastName"] = "Smith"

                MyUI()
                ComposeReaderApp()

            }
        }
    }
}

@Composable
fun ComposeReaderApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
//                    db.collection("users").add(user).addOnSuccessListener {
//                        Log.d("FireBase", "onCreate ${it.id}")
//                    }.addOnFailureListener {
//                        Log.d("FireBase", "Failed to add user ${it}")
//                    }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppNavigation()

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyUI()
    ComposeReaderTheme {
    }
}