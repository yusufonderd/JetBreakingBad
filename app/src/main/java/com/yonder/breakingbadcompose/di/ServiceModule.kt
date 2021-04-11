package com.yonder.breakingbadcompose.di

import com.yonder.breakingbadcompose.data.remote.characters.CharactersApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideCharactersApiService(retrofit: Retrofit): CharactersApiService {
        return retrofit.create()
    }

}