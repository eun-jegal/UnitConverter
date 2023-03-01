package com.example.unitconverter.data.respository

import com.example.unitconverter.data.category.ConversionCategory
import com.example.unitconverter.data.db.ConversionResult
import kotlinx.coroutines.flow.Flow

interface ConversionRepository {
    suspend fun saveResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    fun getSavedResults(): Flow<List<ConversionResult>>
    fun generateCategory(category: String): ConversionCategory
}