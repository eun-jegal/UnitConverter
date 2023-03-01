package com.example.unitconverter.di

import com.example.unitconverter.data.category.ConversionCategoryGenerator
import com.example.unitconverter.data.category.ConversionCategoryGeneratorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CategoryGeneratorModule {

    @Singleton
    @Provides
    fun provideConversionCategoryGenerator(): ConversionCategoryGenerator {
        return ConversionCategoryGeneratorImpl()
    }
}