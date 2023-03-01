package com.example.unitconverter.data.respository

import com.example.unitconverter.data.db.ConversionResult
import kotlinx.coroutines.flow.Flow

interface ConversionRepository {
    suspend fun saveResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun getSavedResults(): Flow<List<ConversionResult>>
}