package com.yonder.breakingbadcompose.ui.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.yonder.breakingbadcompose.ui.characterdetails.CharacterDetails
import com.yonder.breakingbadcompose.ui.common.ErrorView
import com.yonder.breakingbadcompose.ui.common.LoadingView
import com.yonder.breakingbadcompose.ui.main.Screen


@Composable
fun Characters(navController: NavController) {
    val viewModel = hiltViewModel<CharactersViewModel>()
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