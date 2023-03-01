package com.example.unitconverter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unitconverter.data.respository.ConversionRepository

class ConversionViewModelFactory(
    private val repository: ConversionRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConversionViewModel(repository) as T
    }
}