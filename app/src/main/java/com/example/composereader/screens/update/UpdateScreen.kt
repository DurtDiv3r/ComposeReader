package com.example.composereader.screens.update

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composereader.components.MyUI

@Composable
fun UpdateScreen(navController: NavHostController) {
    MyUI()
    Text(text = "Update Screen")
}