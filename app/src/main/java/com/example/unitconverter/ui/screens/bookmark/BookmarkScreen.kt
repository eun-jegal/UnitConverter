package com.example.unitconverter.ui.screens.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.R
import com.example.unitconverter.data.db.ConversionResult
import com.example.unitconverter.ui.screens.SubTopAppBar
import com.example.unitconverter.ui.viewmodel.ConversionViewModel

@Composable
fun BookmarksScreen(
    viewModel: ConversionViewModel,
    onNavigateToMainScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bookmarkList = viewModel.savedResultsFromDB.collectAsState(initial = emptyList())
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
            LazyColumn {
                items(items = bookmarkList.value) { result ->
                    BookmarkCard(
                        result = result,
                        onClickDeleteEvent = { viewModel.deleteResult(it) },
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@Composable
fun BookmarkCard(
    result: ConversionResult,
    onClickDeleteEvent: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .drawBehind {
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 0.5.dp.toPx()
                )
            },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = modifier.fillMaxWidth(0.8f)) {
            Row(modifier = modifier.fillMaxWidth()) {
                Text(text = result.inputNumber, color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = result.inputUnit, color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "=", color = Color.Gray, fontSize = 14.sp)
            }
            Spacer(modifier = modifier.height(4.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = result.outputNumber, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = result.outputUnit, fontSize = 14.sp)
            }
        }
        IconButton(
            modifier = modifier.size(24.dp),
            onClick = { onClickDeleteEvent(result) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_carbon_delete),
                contentDescription = "Delete"
            )
        }
    }
}