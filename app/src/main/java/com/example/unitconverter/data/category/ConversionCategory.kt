package com.example.unitconverter.data.category

interface ConversionCategory {
    fun getFormulaByUnit(unit: String): List<Pair<String, String>>
    fun getDefaultInputUnit(): String
    fun getUnitList(): List<String>
    fun getName(): String
}