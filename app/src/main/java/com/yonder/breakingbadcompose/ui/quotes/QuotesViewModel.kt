package com.yonder.breakingbadcompose.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.repo.QuotesRepository
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.usecase.QuotesUseCase
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.usecase.QuotesUseCaseImpl
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import com.yonder.breakingbadcompose.domain.model.QuoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val quotesUseCase: QuotesUseCase
) : ViewModel() {

    private val _quotes: MutableStateFlow<QuotesUiState> =
        MutableStateFlow(QuotesUiState.Loading)
    val quotes: StateFlow<QuotesUiState> get() = _quotes

    init {
        getQuotes()
    }

    private fun getQuotes() {
        viewModelScope.launch {
            quotesUseCase.getQuotes().collect {  result ->
                result.onSuccess { quotes ->
                    _quotes.value = QuotesUiState.Success(quotes)
                }.onError {error ->
                    _quotes.value = QuotesUiState.Error(error)
                }
            }
        }
    }

}

sealed class QuotesUiState {
    data class Success(val quotes: List<QuoteUiModel>) : QuotesUiState()
    data class Error(val exception: Throwable) : QuotesUiState()
    object Loading : QuotesUiState()
}