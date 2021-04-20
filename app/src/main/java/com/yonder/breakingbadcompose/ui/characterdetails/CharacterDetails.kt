package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.ui.theme.large_padding

@Composable
fun CharacterDetails(navController: NavController) {
    val characterUiModel = navController
        .previousBackStackEntry
        ?.arguments
        ?.getParcelable<CharacterUiModel>(CharacterDetails.CHARACTER_UI_MODEL)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(large_padding),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        CharacterHeaderView(characterUiModel = characterUiModel)
        CharacterNameView(characterUiModel = characterUiModel)

    }

}

object CharacterDetails {
    const val CHARACTER_UI_MODEL = "CHARACTER_UI_MODEL"
}



