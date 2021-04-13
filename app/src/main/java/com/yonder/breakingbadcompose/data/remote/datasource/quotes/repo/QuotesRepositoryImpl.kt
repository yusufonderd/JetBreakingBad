package com.yonder.breakingbadcompose.data.remote.datasource.quotes.repo

import com.yonder.breakingbadcompose.data.remote.datasource.quotes.QuotesApiService
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import com.yonder.breakingbadcompose.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


class QuotesRepositoryImpl @Inject constructor(
    private val apiService: QuotesApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : QuotesRepository {
    override suspend fun getQuotes(): List<QuoteResponse>  = withContext(dispatcher) {
        apiService.getQuotes()
    }
}