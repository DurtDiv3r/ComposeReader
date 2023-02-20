package com.example.composereader.screens.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composereader.components.MyUI

@Composable
fun SearchScreen(navController: NavHostController) {
    MyUI()
    Text(text = "Search Screen")
}
