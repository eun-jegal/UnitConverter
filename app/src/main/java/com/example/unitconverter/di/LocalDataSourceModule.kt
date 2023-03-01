package com.example.unitconverter.di

import com.example.unitconverter.data.ConversionLocalDataSource
import com.example.unitconverter.data.ConversionLocalDataSourceImpl
import com.example.unitconverter.data.db.ConversionDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideConversionLocalDataSource(
        conversionDAO: ConversionDAO
    ): ConversionLocalDataSource {
        return ConversionLocalDataSourceImpl(conversionDAO)
    }
}