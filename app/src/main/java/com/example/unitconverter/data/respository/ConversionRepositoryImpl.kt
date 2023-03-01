package com.example.unitconverter.data.respository

import com.example.unitconverter.data.ConversionLocalDataSource
import com.example.unitconverter.data.category.ConversionCategory
import com.example.unitconverter.data.category.ConversionCategoryGenerator
import com.example.unitconverter.data.db.ConversionResult
import kotlinx.coroutines.flow.Flow

class ConversionRepositoryImpl(
    private val localDataSource: ConversionLocalDataSource,
    private val categoryGenerator: ConversionCategoryGenerator
) : ConversionRepository {
    override suspend fun saveResult(result: ConversionResult) {
        localDataSource.saveResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        localDataSource.deleteResult(result)
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
        return localDataSource.getSavedResults()
    }

    override fun generateCategory(category: String): ConversionCategory {
        return categoryGenerator.generate(category)
    }
}