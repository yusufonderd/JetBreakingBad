package com.yonder.breakingbadcompose.ui.quotes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import com.yonder.breakingbadcompose.ui.characters.CharactersUiState
import com.yonder.breakingbadcompose.ui.common.ErrorView
import com.yonder.breakingbadcompose.ui.common.LoadingView
import com.yonder.breakingbadcompose.ui.theme.padding_normal

@Composable
fun Quotes(navController: NavController) {
    val viewModel = hiltNavGraphViewModel<QuotesViewModel>()
    val quotesUiState by viewModel.quotes.collectAsState()

    when (quotesUiState) {
        is QuotesUiState.Loading -> {
            LoadingView()
        }

        is QuotesUiState.Success -> {
            LazyColumn {
                item {
                    (quotesUiState as QuotesUiState.Success).quotes.forEach { quoteModel ->
                        QuoteRowView(quoteUiModel = quoteModel)
                    }
                }
            }
        }
        is QuotesUiState.Error -> {
            ErrorView(
                errorMessage =
                (quotesUiState as CharactersUiState.Error)
                    .exception.localizedMessage.orEmpty()
            )
        }

    }


/*
    Button(onClick = { navController.navigate("characters") }) {
        Text(text = "Navigate next")
    }*/
}