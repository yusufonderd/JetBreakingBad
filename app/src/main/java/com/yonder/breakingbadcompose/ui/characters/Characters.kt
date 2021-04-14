package com.yonder.breakingbadcompose.ui.characters

import android.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.navigate
import com.yonder.breakingbadcompose.ui.characterdetails.CharacterDetails
import com.yonder.breakingbadcompose.ui.common.ErrorView
import com.yonder.breakingbadcompose.ui.common.LoadingView
import com.yonder.breakingbadcompose.ui.main.Screen
import com.yonder.breakingbadcompose.ui.theme.White


@Composable
fun Characters(navController: NavController) {
    val viewModel = hiltNavGraphViewModel<CharactersViewModel>()
    val characterState by viewModel.characters.collectAsState()

    when (characterState) {
        is CharactersUiState.Loading -> {
            LoadingView()
        }

        is CharactersUiState.Success -> {
            LazyColumn {
                item {
                    (characterState as CharactersUiState.Success).characters.forEach { characterUiModel ->
                        CharacterRowView(characterUIModel = characterUiModel,onClick = {
                            navController.currentBackStackEntry?.arguments?.putParcelable(
                                CharacterDetails.CHARACTER_UI_MODEL,
                                characterUiModel
                            )
                            navController.navigate(Screen.CharacterDetails.route)
                        })
                    }
                }
            }
        }
        is CharactersUiState.Error -> {
            ErrorView(
                errorMessage =
                (characterState as CharactersUiState.Error)
                    .exception.localizedMessage.orEmpty()
            )
        }

    }

}