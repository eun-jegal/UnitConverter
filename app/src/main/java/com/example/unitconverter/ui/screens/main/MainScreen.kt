package com.example.unitconverter.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.R
import com.example.unitconverter.ui.viewmodel.ConversionViewModel

val conversions = listOf(
    Pair(R.drawable.ic_carbon_weight, "Weight"),
    Pair(R.drawable.ic_carbon_length, "Length"),
    Pair(R.drawable.ic_carbon_area, "Area"),
    Pair(R.drawable.ic_carbon_temperature, "Temperature"),
    Pair(R.drawable.ic_carbon_speed, "Speed"),
    Pair(R.drawable.ic_carbon_time, "Time"),
    Pair(R.drawable.ic_carbon_volume, "Volume"),
    Pair(R.drawable.ic_carbon_fuel, "Fuel\nEconomy"),
    Pair(R.drawable.ic_carbon_frequency, "Frequency"),
    Pair(R.drawable.ic_carbon_data_transfer_rate, "Data\nTransfer Rate"),
    Pair(R.drawable.ic_carbon_digital_storage, "Digital\nStorage"),
)

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onNavigateToConversionScreen: (String) -> Unit,
    onNavigateToBookmarkScreen: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.app_background))
    ) {
        MainTopAppBar {
            onNavigateToBookmarkScreen()
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.app_background))
                .padding(16.dp)
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Pick a category",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(conversions.size) { index ->
                        CategoryCard(
                            modifier = modifier,
                            drawableId = conversions[index].first,
                            category = conversions[index].second,
                            onNavigateToConversionScreen = onNavigateToConversionScreen
                        )
                    }
                })
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryCard(
    modifier: Modifier,
    drawableId: Int,
    category: String,
    onNavigateToConversionScreen: (String) -> Unit
) {
    Card(
        elevation = 2.dp,
        modifier = modifier.aspectRatio(1f),
        shape = RoundedCornerShape(12.dp),
        onClick = { onNavigateToConversionScreen(category) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(painter = painterResource(id = drawableId), contentDescription = category)
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = category,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            )
        }
    }

}