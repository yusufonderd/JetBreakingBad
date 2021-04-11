package com.yonder.breakingbadcompose.data.remote.characters

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters() : Flow<NetworkResult<List<CharacterResponse>>>
}