package com.example.unitconverter.ui.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R

@Composable
fun MainTopAppBar(
    onClickBookmark: () -> Unit
) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.color_primary),
        title = {
            Text(text = "Unit Converter", color = Color.White)
        },
        actions = {
            IconButton(onClick = { onClickBookmark() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_bookmarks_24),
                    tint = Color.White,
                    contentDescription = "Bookmarks"
                )
            }
        }
    )
}

