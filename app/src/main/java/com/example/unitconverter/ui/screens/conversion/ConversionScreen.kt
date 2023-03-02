package com.example.unitconverter.ui.screens.conversion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R
import com.example.unitconverter.ui.screens.SubTopAppBar
import com.example.unitconverter.ui.viewmodel.ConversionViewModel

@Composable
fun ConversionScreen(
    category: String,
    viewModel: ConversionViewModel,
    onNavigateToMainScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.app_background))
    ) {
        SubTopAppBar(appbarTitle = category) {
            onNavigateToMainScreen()
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            InputUI(
                inputNumber = viewModel.inputNumber,
                inputUnit = viewModel.inputUnit,
                unitList = viewModel.unitList,
                calculate = {
                    viewModel.updateCalculatedResults()
                },
                modifier = modifier
            )
            OutputUI(
                inputNumber = viewModel.inputNumber,
                inputUnit = viewModel.inputUnit,
                resultList = viewModel.calculatedResults.observeAsState(initial = emptyList()),
                onClickSave = {
                    viewModel.saveResult(it)
                },
                modifier = modifier
            )
        }
    }

}

