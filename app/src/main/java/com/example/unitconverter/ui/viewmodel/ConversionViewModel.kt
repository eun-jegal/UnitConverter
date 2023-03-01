package com.example.unitconverter.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.unitconverter.data.category.ConversionCategory
import com.example.unitconverter.data.category.Weight
import com.example.unitconverter.data.db.ConversionResult
import com.example.unitconverter.data.respository.ConversionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConversionViewModel(
    private val repository: ConversionRepository
) : ViewModel() {

    val selectedCategory: MutableState<ConversionCategory> = mutableStateOf(Weight())
    val inputNumber = mutableStateOf("1.0")
    val inputUnit = mutableStateOf("")

    val resultList = liveData {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSavedResults().collect {
                emit(it)
            }
        }
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