package com.example.unitconverter.data.category

interface ConversionCategoryGenerator {
    fun generate(category: String): ConversionCategory
}