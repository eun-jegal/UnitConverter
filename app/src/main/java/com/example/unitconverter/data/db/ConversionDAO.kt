package com.example.unitconverter.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversionDAO {
    @Insert
    suspend fun save(result: ConversionResult)

    @Delete
    suspend fun delete(result: ConversionResult)

    @Query("SELECT * FROM conversion_result")
    fun getSavedResults(): Flow<List<ConversionResult>>
}