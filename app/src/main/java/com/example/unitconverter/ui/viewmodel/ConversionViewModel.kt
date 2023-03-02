package com.example.unitconverter.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitconverter.data.db.ConversionResult
import com.example.unitconverter.data.respository.ConversionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConversionViewModel(
    private val repository: ConversionRepository
) : ViewModel() {

    private val selectedCategory = mutableStateOf("Weight")
    private var conversionCategory = repository.generateCategory(selectedCategory.toString())
    val inputNumber = mutableStateOf("0.0")
    val inputUnit = mutableStateOf("Pound")
    val unitList = conversionCategory.getUnitList()

    private val _calculatedResults: MutableLiveData<List<Pair<String, String>>> = MutableLiveData()
    val calculatedResults: LiveData<List<Pair<String, String>>>
        get() = _calculatedResults
    val savedResultsFromDB = repository.getSavedResults()

    fun updateConversionCategory(category: String) {
        conversionCategory = repository.generateCategory(category)
    }

    fun updateCalculatedResults() {
        val results = mutableListOf<Pair<String, String>>()
        conversionCategory.getFormulaByUnit(inputUnit.value).forEach { pair ->
            val outputUnit = pair.first
            val multiply = pair.second.toDouble()
            val outputNum = inputNumber.value.toDouble() * multiply
            results.add(Pair(outputNum.toString(), outputUnit))
        }
        _calculatedResults.postValue(results)
    }

    fun saveResult(result: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveResult(result)
        }
    }

    fun deleteResult(result: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(result)
        }
    }
}