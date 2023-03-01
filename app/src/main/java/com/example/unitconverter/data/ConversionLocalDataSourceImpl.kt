package com.example.unitconverter.data

import com.example.unitconverter.data.db.ConversionDAO
import com.example.unitconverter.data.db.ConversionResult
import kotlinx.coroutines.flow.Flow

class ConversionLocalDataSourceImpl(
    private val conversionDAO: ConversionDAO
): ConversionLocalDataSource {
    override suspend fun saveResult(result: ConversionResult) {
        conversionDAO.save(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        conversionDAO.delete(result)
    }

    override suspend fun getSavedResults(): Flow<List<ConversionResult>> {
        return conversionDAO.getSavedResults()
    }
}