package com.yonder.breakingbadcompose.data.remote.datasource.characters.repo

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.data.remote.datasource.characters.CharactersApiService
import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import com.yonder.breakingbadcompose.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val apiService: CharactersApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : CharactersRepository {


    override suspend fun getCharacters(): List<CharacterResponse> = withContext(ioDispatcher) {
        apiService.getCharacters()
    }
}