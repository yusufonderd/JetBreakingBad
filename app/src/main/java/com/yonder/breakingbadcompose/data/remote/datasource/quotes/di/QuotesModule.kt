package com.yonder.breakingbadcompose.data.remote.datasource.quotes.di

import com.yonder.breakingbadcompose.data.remote.datasource.quotes.QuotesApiService
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.repo.QuotesRepository
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.repo.QuotesRepositoryImpl
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.usecase.QuotesUseCase
import com.yonder.breakingbadcompose.data.remote.datasource.quotes.usecase.QuotesUseCaseImpl
import com.yonder.breakingbadcompose.data.remote.response.QuoteResponse
import com.yonder.breakingbadcompose.di.IoDispatcher
import com.yonder.breakingbadcompose.domain.mapper.Mapper
import com.yonder.breakingbadcompose.domain.mapper.QuoteMapper
import com.yonder.breakingbadcompose.domain.model.QuoteUiModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

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


    @Provides
    fun provideQuotesMapper(): Mapper<QuoteResponse, QuoteUiModel> =
        QuoteMapper()

    @Provides
    fun provideQuotesUseCase(
        repository: QuotesRepository,
        mapper: QuoteMapper,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): QuotesUseCase {
        return QuotesUseCaseImpl(repository, mapper, dispatcher)
    }
}