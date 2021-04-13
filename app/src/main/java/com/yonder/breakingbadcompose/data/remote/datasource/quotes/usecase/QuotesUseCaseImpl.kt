package com.yonder.breakingbadcompose.data.remote.datasource.quotes.usecase

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.repo.QuotesRepository
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import com.yonder.breakingbadcompose.di.IoDispatcher
import com.yonder.breakingbadcompose.domain.mapper.base.Mapper
import com.yonder.breakingbadcompose.domain.model.QuoteUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class QuotesUseCaseImpl @Inject constructor(
    private val repository: QuotesRepository,
    private val mapper: Mapper<QuoteResponse, QuoteUiModel>,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : QuotesUseCase {

    override fun getQuotes() = flow {
        emit(NetworkResult.Loading)
        emit(NetworkResult.Success(repository.getQuotes().map { mapper.map(it) }))
    }.catch { error ->
        emit(NetworkResult.Error(error))
    }.flowOn(dispatcher)

}