package com.yonder.breakingbadcompose.domain.mapper


import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import com.yonder.breakingbadcompose.domain.mapper.base.Mapper
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import javax.inject.Inject

class CharacterMapper @Inject constructor(): Mapper<CharacterResponse, CharacterUiModel> {
    override fun map(input: CharacterResponse): CharacterUiModel = CharacterUiModel(input.name.orEmpty())
}