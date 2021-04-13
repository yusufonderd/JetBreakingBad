package com.yonder.breakingbadcompose.data.remote.repo.quotes.di

import com.yonder.breakingbadcompose.data.remote.repo.quotes.QuotesApiService
import com.yonder.breakingbadcompose.data.remote.repo.quotes.QuotesRepository
import com.yonder.breakingbadcompose.data.remote.repo.quotes.QuotesRepositoryImpl
import com.yonder.breakingbadcompose.di.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object QuotesModule {

    @Provides
    fun provideQuotesRepository(
        apiService: QuotesApiService,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): QuotesRepository {
        return QuotesRepositoryImpl(apiService, dispatcher)
    }
}