package com.yonder.breakingbadcompose.ui.quotes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.yonder.breakingbadcompose.R

@Composable
fun Quotes(navController: NavController) {
    val viewModel = hiltNavGraphViewModel<QuotesViewModel>()
    val quotesUiState by viewModel.quotes.collectAsState()

    when (quotesUiState) {
        is QuotesUiState.Loading -> {
            Text(text = stringResource(id = R.string.loading))
        }

        is QuotesUiState.Success -> {
            LazyColumn {
                item {
                    (quotesUiState as QuotesUiState.Success).characters.forEach {
                        Text(text = it.quote.orEmpty())
                    }
                }
            }
        }
        is QuotesUiState.Error -> {
            Text(text = stringResource(id = R.string.error_occurred))
        }

    }


/*
    Button(onClick = { navController.navigate("characters") }) {
        Text(text = "Navigate next")
    }*/
}