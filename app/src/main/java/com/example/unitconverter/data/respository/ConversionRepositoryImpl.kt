package com.example.unitconverter.data.respository

import com.example.unitconverter.data.ConversionLocalDataSource
import com.example.unitconverter.data.db.ConversionResult
import kotlinx.coroutines.flow.Flow

class ConversionRepositoryImpl(
    private val localDataSource: ConversionLocalDataSource
) : ConversionRepository {
    override suspend fun saveResult(result: ConversionResult) {
        localDataSource.saveResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        localDataSource.deleteResult(result)
    }

    override suspend fun getSavedResults(): Flow<List<ConversionResult>> {
        return localDataSource.getSavedResults()
    }
}