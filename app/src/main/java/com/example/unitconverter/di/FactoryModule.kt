package com.example.unitconverter.di

import com.example.unitconverter.data.respository.ConversionRepository
import com.example.unitconverter.ui.viewmodel.ConversionViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FactoryModule {

    @Singleton
    @Provides
    fun provideConversionViewModelFactory(
        conversionRepository: ConversionRepository
    ): ConversionViewModelFactory {
        return ConversionViewModelFactory(conversionRepository)
    }
}