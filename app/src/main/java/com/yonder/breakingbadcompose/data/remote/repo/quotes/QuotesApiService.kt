package com.yonder.breakingbadcompose.data.remote.repo.quotes

import com.yonder.breakingbadcompose.core.ApiConstants
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import retrofit2.http.GET



interface QuotesApiService {
    @GET(ApiConstants.Endpoint.QUOTES)
    suspend fun getQuotes() : List<QuoteResponse>
}