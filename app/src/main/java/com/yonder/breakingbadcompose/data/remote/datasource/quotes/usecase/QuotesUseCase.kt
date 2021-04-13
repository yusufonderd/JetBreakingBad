package com.yonder.breakingbadcompose.data.remote.datasource.quotes.usecase

import com.yonder.breakingbadcompose.core.NetworkResult
import com.yonder.breakingbadcompose.domain.model.QuoteUiModel
import kotlinx.coroutines.flow.Flow

interface QuotesUseCase {
    fun getQuotes(): Flow<NetworkResult<List<QuoteUiModel>>>
}