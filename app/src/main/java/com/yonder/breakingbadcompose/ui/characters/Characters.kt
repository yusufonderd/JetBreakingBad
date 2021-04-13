package com.yonder.breakingbadcompose.ui.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import com.yonder.breakingbadcompose.R


@Composable
fun Characters(navController: NavController) {
    val viewModel = hiltNavGraphViewModel<CharactersViewModel>()
    val characterState by viewModel.characters.collectAsState()

    when (characterState) {
        is CharactersUiState.Loading -> {
            Text(text = stringResource(id = R.string.loading))
        }

        is CharactersUiState.Success -> {
            LazyColumn {
                item {
                    (characterState as CharactersUiState.Success).characters.forEach {
                        Text(text = it.name.orEmpty())
                    }
                }
            }
        }
        is CharactersUiState.Error -> {
            Text(text = stringResource(id = R.string.error_occurred))
        }

    }

}