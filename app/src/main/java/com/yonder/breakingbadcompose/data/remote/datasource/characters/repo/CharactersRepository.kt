package com.yonder.breakingbadcompose.data.remote.datasource.characters.repo

import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse

interface CharactersRepository {
   suspend fun getCharacters() : List<CharacterResponse>
}