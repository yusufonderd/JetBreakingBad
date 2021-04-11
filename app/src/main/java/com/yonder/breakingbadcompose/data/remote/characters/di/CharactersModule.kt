package com.yonder.breakingbadcompose.data.remote.characters.di

import com.yonder.breakingbadcompose.data.remote.characters.CharactersApiService
import com.yonder.breakingbadcompose.data.remote.characters.CharactersRepository
import com.yonder.breakingbadcompose.data.remote.characters.CharactersRepositoryImpl
import com.yonder.breakingbadcompose.di.IoDispatcher
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
}