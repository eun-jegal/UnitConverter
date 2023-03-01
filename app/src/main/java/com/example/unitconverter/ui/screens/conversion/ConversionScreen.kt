package com.example.unitconverter.ui.screens.conversion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R
import com.example.unitconverter.ui.screens.SubTopAppBar

@Composable
fun ConversionScreen(
    category: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.app_background))
    ) {
        SubTopAppBar(appbarTitle = category) {

        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            InputUI(modifier)
            OutputUI("", modifier, listOf())
        }
    }

}

