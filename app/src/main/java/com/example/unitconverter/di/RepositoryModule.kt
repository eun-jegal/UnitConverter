package com.example.unitconverter.di

import com.example.unitconverter.data.ConversionLocalDataSource
import com.example.unitconverter.data.respository.ConversionRepository
import com.example.unitconverter.data.respository.ConversionRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideConversionRepository(
        localDataSource: ConversionLocalDataSource
    ): ConversionRepository {
        return ConversionRepositoryImpl(localDataSource)
    }
}