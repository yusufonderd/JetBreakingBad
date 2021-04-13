package com.yonder.breakingbadcompose.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonder.breakingbadcompose.data.remote.repo.characters.CharactersRepository
import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharactersRepository
) : ViewModel() {

    private val _characters: MutableStateFlow<CharactersUiState> =
        MutableStateFlow(CharactersUiState.Loading)
    val characters: StateFlow<CharactersUiState> get() = _characters

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            repository.getCharacters().collect { result ->
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
    data class Success(val characters: List<CharacterResponse>) : CharactersUiState()
    data class Error(val exception: Throwable) : CharactersUiState()
    object Loading : CharactersUiState()
}
