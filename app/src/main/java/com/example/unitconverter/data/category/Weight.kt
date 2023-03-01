package com.example.unitconverter.data.category

class Weight : ConversionCategory {

    private val poundToOthers = listOf(
        Pair("Metric ton", "0.000453592"),
        Pair("Kilogram", "0.453592f"),
        Pair("Gram", "453.592"),
        Pair("Milligram", "453592"),
        Pair("Microgram", "4.536e+8"),
        Pair("Imperial ton", "0.000446429"),
        Pair("US ton", "0.0005"),
        Pair("Stone", "0.0714286"),
        Pair("Ounce", "16"),
    )

    override fun getFormulaByUnit(unit: String): List<Pair<String, String>> {
        return when (unit) {
            "Pound" -> poundToOthers
            else -> listOf()
        }
    }

    override fun getDefaultInputUnit(): String {
        return "Pound"
    }

    override fun getUnitList(): List<String> {
        return listOf(
            "Metric ton",
            "Kilogram",
            "Gram",
            "Milligram",
            "Microgram",
            "Imperial ton",
            "US ton",
            "Stone",
            "Ounce"
        )
    }

    override fun getName(): String {
        return "Weight"
    }
}