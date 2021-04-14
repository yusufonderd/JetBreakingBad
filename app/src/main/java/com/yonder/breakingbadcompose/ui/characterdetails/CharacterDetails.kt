package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel

@Composable
fun CharacterDetails(navController: NavController) {
    val characterUiModel = navController
        .previousBackStackEntry
        ?.arguments
        ?.getParcelable<CharacterUiModel>(CharacterDetails.CHARACTER_UI_MODEL)

    Text(text = characterUiModel?.name.orEmpty())

}

object CharacterDetails {
    const val CHARACTER_UI_MODEL = "CHARACTER_UI_MODEL"
}




