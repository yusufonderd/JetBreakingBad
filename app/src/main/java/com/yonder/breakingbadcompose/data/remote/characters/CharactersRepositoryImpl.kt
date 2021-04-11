package com.yonder.breakingbadcompose.data.remote.characters

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val apiService: CharactersApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : CharactersRepository {
    override  fun getCharacters() = flow {
        emit(NetworkResult.Loading)
        emit(NetworkResult.Success(apiService.getCharacters()))
    }.catch { error ->
        emit(NetworkResult.Error(error))
    }.flowOn(ioDispatcher)
}