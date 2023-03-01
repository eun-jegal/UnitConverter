package com.example.unitconverter.ui.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.unitconverter.R

@Composable
fun SubTopAppBar(
    appbarTitle: String,
    onClickNavigateUp: () -> Unit
) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.color_primary),
        title = { Text(text = appbarTitle, color = Color.White) },
        navigationIcon = {
            IconButton(onClick = { onClickNavigateUp() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    )
}