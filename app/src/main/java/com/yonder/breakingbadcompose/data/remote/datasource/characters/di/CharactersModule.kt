package com.yonder.breakingbadcompose.data.remote.datasource.characters.di

import com.yonder.breakingbadcompose.data.remote.datasource.characters.CharactersApiService
import com.yonder.breakingbadcompose.data.remote.datasource.characters.repo.CharactersRepository
import com.yonder.breakingbadcompose.data.remote.datasource.characters.repo.CharactersRepositoryImpl
import com.yonder.breakingbadcompose.data.remote.datasource.characters.usecase.CharactersUseCase
import com.yonder.breakingbadcompose.data.remote.datasource.characters.usecase.CharactersUseCaseImpl
import com.yonder.breakingbadcompose.data.remote.response.CharacterResponse
import com.yonder.breakingbadcompose.di.IoDispatcher
import com.yonder.breakingbadcompose.domain.mapper.CharacterMapper
import com.yonder.breakingbadcompose.domain.mapper.base.Mapper
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object CharactersModule {
    @Provides
    fun provideCharacterRepository(
        apiService: CharactersApiService,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): CharactersRepository {
        return CharactersRepositoryImpl(apiService, dispatcher)
    }

    @Provides
    fun provideCharacterMapper(): Mapper<CharacterResponse, CharacterUiModel> =
        CharacterMapper()

    @Provides
    fun provideCharacterUseCase(
        repository: CharactersRepository,
        mapper: CharacterMapper,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): CharactersUseCase {
        return CharactersUseCaseImpl(repository, mapper, dispatcher)
    }
}