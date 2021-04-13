package com.yonder.breakingbadcompose.data.remote.repo.quotes

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import kotlinx.coroutines.flow.Flow




interface QuotesRepository {
    fun getQuotes() : Flow<NetworkResult<List<QuoteResponse>>>
}