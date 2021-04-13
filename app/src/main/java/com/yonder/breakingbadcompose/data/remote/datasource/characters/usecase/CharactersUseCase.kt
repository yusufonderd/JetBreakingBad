package com.yonder.breakingbadcompose.data.remote.datasource.characters.usecase

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import kotlinx.coroutines.flow.Flow

interface CharactersUseCase {
    fun getCharacters(): Flow<NetworkResult<List<CharacterUiModel>>>
}