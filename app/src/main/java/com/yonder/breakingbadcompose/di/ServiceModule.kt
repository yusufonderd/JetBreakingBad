package com.yonder.breakingbadcompose.di

import com.yonder.breakingbadcompose.data.remote.datasource.characters.CharactersApiService
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.QuotesApiService
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

    @Provides
    @Singleton
    fun provideQuotesApiService(retrofit: Retrofit): QuotesApiService {
        return retrofit.create()
    }

}