package com.example.composereader.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NetworkWifi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composereader.components.MyUI

@Composable
fun Home(navController: NavHostController) {
    MyUI()
    Scaffold(modifier = Modifier.background(Color.Transparent), bottomBar = {}, floatingActionButton = {
        FABContent {}
    }) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)) {
            MyUI()
        }
    }
}

@Composable
fun FABContent(onTouch: () -> Unit) {
    FloatingActionButton(onClick = { onTouch() }, shape = RoundedCornerShape(50), backgroundColor = Color(0xFF8B418FC) ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add item", tint = Color(0xFF36003C))
    }
}