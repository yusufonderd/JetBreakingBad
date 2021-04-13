package com.yonder.breakingbadcompose.domain.mapper

import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import com.yonder.breakingbadcompose.domain.model.QuoteUiModel

class QuoteMapper: Mapper<QuoteResponse,QuoteUiModel> {
    override fun map(input: QuoteResponse): QuoteUiModel = QuoteUiModel(input.quote.orEmpty())
}