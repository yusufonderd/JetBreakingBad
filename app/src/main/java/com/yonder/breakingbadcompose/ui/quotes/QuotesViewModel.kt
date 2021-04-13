package com.yonder.breakingbadcompose.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonder.breakingbadcompose.data.remote.repo.quotes.QuotesRepository
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val repository: QuotesRepository
) : ViewModel() {

    private val _quotes: MutableStateFlow<QuotesUiState> =
        MutableStateFlow(QuotesUiState.Loading)
    val quotes: StateFlow<QuotesUiState> get() = _quotes

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            repository.getQuotes().collect { result ->
                result.onSuccess { characters ->
                    _quotes.value = QuotesUiState.Success(characters)
                }.onError { error ->
                    _quotes.value = QuotesUiState.Error(error)
                }
            }
        }
    }

}

sealed class QuotesUiState {
    data class Success(val characters: List<QuoteResponse>) : QuotesUiState()
    data class Error(val exception: Throwable) : QuotesUiState()
    object Loading : QuotesUiState()
}