package com.yonder.breakingbadcompose.ui.quotes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import com.yonder.breakingbadcompose.ui.common.ErrorView
import com.yonder.breakingbadcompose.ui.common.LoadingView

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
                (quotesUiState as QuotesUiState.Error)
                    .exception.localizedMessage.orEmpty()
            )
        }

    }

}