package com.yonder.breakingbadcompose.data.remote.datasource.characters.usecase

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.data.remote.datasource.characters.repo.CharactersRepository
import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import com.yonder.breakingbadcompose.di.IoDispatcher
import com.yonder.breakingbadcompose.domain.mapper.base.Mapper
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharactersUseCaseImpl @Inject constructor(
    private val repository: CharactersRepository,
    private val mapper: Mapper<CharacterResponse, CharacterUiModel>,
    @IoDispatcher private val dispatcher: CoroutineDispatcher

) : CharactersUseCase {
    override fun getCharacters(): Flow<NetworkResult<List<CharacterUiModel>>> {
        return flow {
            emit(NetworkResult.Loading)
            emit(NetworkResult.Success(repository.getCharacters().map { mapper.map(it) }))
        }.catch { error ->
            emit(NetworkResult.Error(error))
        }.flowOn(dispatcher)
    }
}