package com.example.unitconverter.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversion_result")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "input_num")
    val inputNumber: Int,
    @ColumnInfo(name = "input_unit")
    val inputUnit: String,
    @ColumnInfo(name = "output_num")
    val outputNumber: Int,
    @ColumnInfo(name = "output_unit")
    val outputUnit: String
)
