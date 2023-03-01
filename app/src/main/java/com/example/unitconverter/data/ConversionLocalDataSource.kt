package com.example.unitconverter.data

import com.example.unitconverter.data.db.ConversionResult
import kotlinx.coroutines.flow.Flow

interface ConversionLocalDataSource {
    suspend fun saveResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    fun getSavedResults(): Flow<List<ConversionResult>>
}