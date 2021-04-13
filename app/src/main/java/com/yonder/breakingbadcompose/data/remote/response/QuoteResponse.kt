package com.yonder.breakingbadcompose.data.remote.response

import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    @SerializedName("quote_id") val id: Int?,
    val quote: String?,
    val author: String?,
    val series: String?,
)
