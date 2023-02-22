package com.example.composereader.screens.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composereader.components.MyUI

@Composable
fun DetailsScreen(navController: NavHostController) {
    MyUI()
    Text(text = "Details Screen")
}
