package com.example.composereader.screens.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composereader.components.MyUI

@Composable
fun Home(navController: NavHostController) {
    MyUI()
    Text(text = "Home Screen")
}