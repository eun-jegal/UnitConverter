package com.example.unitconverter.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.unitconverter.data.db.ConversionResult
import com.example.unitconverter.data.respository.ConversionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConversionViewModel(
    private val repository: ConversionRepository
) : ViewModel() {

    val selectedCategory = mutableStateOf("Weight")
    val inputNumber = mutableStateOf("1.0")
    val inputUnit = mutableStateOf("")
    val unitList = repository.generateCategory(selectedCategory.toString()).getUnitList()

    val resultList = repository.getSavedResults()

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