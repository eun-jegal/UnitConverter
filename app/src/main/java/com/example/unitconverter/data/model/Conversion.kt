package com.example.unitconverter.data.model

data class Conversion(
    val id: Int,
    val inputNumber: Int,
    val convertFrom: String,
    val convertTo: String,
    val multiplyBy: Double
)
