package com.example.unitconverter.ui.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R

@Composable
fun SubTopAppBar(
    appTitle: String,
    onClickNavigateUp: () -> Unit
) {
    TopAppBar(
        elevation = 4.dp,
        title = { Text(text = appTitle) },
        navigationIcon = {
            IconButton(onClick = { onClickNavigateUp() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = "Back"
                )
            }
        }
    )
}