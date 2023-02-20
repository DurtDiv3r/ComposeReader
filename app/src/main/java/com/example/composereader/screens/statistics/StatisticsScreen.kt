package com.example.composereader.screens.statistics

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composereader.components.MyUI

@Composable
fun StatsScreen(navController: NavHostController) {
    MyUI()
    Text(text = "Stats Screen")
}