package com.example.unitconverter.ui.viewmodel

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