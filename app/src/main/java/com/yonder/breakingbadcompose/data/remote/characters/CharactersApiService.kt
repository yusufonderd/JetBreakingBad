package com.yonder.breakingbadcompose.data.remote.characters

import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import retrofit2.http.GET

interface CharactersApiService {
    @GET("characters")
    suspend fun getCharacters() : List<CharacterResponse>
}