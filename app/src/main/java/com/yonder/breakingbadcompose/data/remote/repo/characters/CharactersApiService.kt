package com.yonder.breakingbadcompose.data.remote.repo.characters

import com.yonder.breakingbadcompose.core.ApiConstants
import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import retrofit2.http.GET

interface CharactersApiService {
    @GET(ApiConstants.Endpoint.CHARACTERS)
    suspend fun getCharacters() : List<CharacterResponse>
}