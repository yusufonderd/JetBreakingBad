package com.yonder.breakingbadcompose.data.remote.repo.quotes

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject



class QuotesRepositoryImpl @Inject constructor(
    private val apiService: QuotesApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : QuotesRepository {
    override  fun getQuotes() = flow {
        emit(NetworkResult.Loading)
        emit(NetworkResult.Success(apiService.getQuotes()))
    }.catch { error ->
        emit(NetworkResult.Error(error))
    }.flowOn(ioDispatcher)
}