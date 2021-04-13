package com.yonder.breakingbadcompose.domain.mapper

import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import com.yonder.breakingbadcompose.domain.model.QuoteUiModel
import javax.inject.Inject

class QuoteMapper @Inject constructor(): Mapper<QuoteResponse,QuoteUiModel> {
    override fun map(input: QuoteResponse): QuoteUiModel = QuoteUiModel(input.quote.orEmpty())
}