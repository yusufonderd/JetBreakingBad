package com.yonder.breakingbadcompose.ui.quotes

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

@Composable
fun Quotes(navController: NavController) {
    Button(onClick = { navController.navigate("characters") }) {
        Text(text = "Navigate next")
    }
}