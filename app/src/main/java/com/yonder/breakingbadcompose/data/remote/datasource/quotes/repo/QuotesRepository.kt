package com.yonder.breakingbadcompose.data.remote.datasource.quotes.repo

import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse

interface QuotesRepository {
    suspend fun getQuotes() : List<QuoteResponse>
}