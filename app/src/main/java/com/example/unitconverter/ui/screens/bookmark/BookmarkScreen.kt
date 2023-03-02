package com.example.unitconverter.ui.screens.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.unitconverter.R
import com.example.unitconverter.ui.screens.SubTopAppBar
import com.example.unitconverter.ui.viewmodel.ConversionViewModel

@Composable
fun BookmarksScreen(
    viewModel: ConversionViewModel,
    onNavigateToMainScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val resultList = viewModel.savedResultsFromDB.collectAsState(initial = emptyList())

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.app_background))
    ) {
        SubTopAppBar(appbarTitle = "Bookmark") {
            onNavigateToMainScreen()
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn{

            }
        }
    }
}

@Composable
fun BookmarkCard(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(modifier = modifier.fillMaxWidth(0.8f)) {
            Row(modifier = modifier.fillMaxWidth()) {
                Text(text = "input number")
                Text(text = "input unit")
                Text(text = "=")
            }
            Spacer(modifier = modifier.height(4.dp))
            Row(modifier = modifier.fillMaxWidth()) {
                Text(text = "output number")
                Text(text = "output unit")
            }
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_carbon_delete),
                contentDescription = "Delete"
            )
        }
    }
}