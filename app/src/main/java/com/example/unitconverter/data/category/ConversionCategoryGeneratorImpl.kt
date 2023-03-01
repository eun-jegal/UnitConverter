package com.example.unitconverter.data.category

class ConversionCategoryGeneratorImpl: ConversionCategoryGenerator {
    override fun generate(category: String): ConversionCategory {
        return Weight()
    }
}