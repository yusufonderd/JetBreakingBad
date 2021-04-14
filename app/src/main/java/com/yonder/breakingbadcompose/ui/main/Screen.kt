package com.yonder.breakingbadcompose.ui.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.yonder.breakingbadcompose.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Characters : Screen(Route.CHARACTERS, R.string.characters, Icons.Filled.Star)
    object Quotes : Screen(Route.QUOTES, R.string.quotes, Icons.Filled.List)
    object CharacterDetails : Screen(Route.CHARACTER_DETAILS, R.string.character_details, Icons.Filled.Person)
}


object Route {
    const val CHARACTER_DETAILS = "characterDetails"
    const val QUOTES = "quotes"
    const val CHARACTERS = "characters"
}