package com.yonder.breakingbadcompose.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonder.breakingbadcompose.data.remote.datasource.characters.usecase.CharactersUseCase
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase
) : ViewModel() {

    private val _characters: MutableStateFlow<CharactersUiState> =
        MutableStateFlow(CharactersUiState.Loading)
    val characters: StateFlow<CharactersUiState> get() = _characters

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            charactersUseCase.getCharacters().collect { result ->
                result.onSuccess { characters ->
                    _characters.value = CharactersUiState.Success(characters)
                }.onError { error ->
                    _characters.value = CharactersUiState.Error(error)
                }
            }
        }
    }

}

sealed class CharactersUiState {
    data class Success(val characters: List<CharacterUiModel>) : CharactersUiState()
    data class Error(val exception: Throwable) : CharactersUiState()
    object Loading : CharactersUiState()
}
