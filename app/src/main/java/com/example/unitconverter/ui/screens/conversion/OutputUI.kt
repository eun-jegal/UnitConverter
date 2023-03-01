package com.example.unitconverter.ui.screens.conversion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.R

@Composable
fun OutputUI(
    originalUnit: String,
    modifier: Modifier = Modifier,
    conversionList: List<String>
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(text = "is equal to", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(content = {
            items(conversionList.size) {
                ConversionResultCard(originalUnit = originalUnit, modifier = modifier)
            }
        })
    }
}

@Composable
fun ConversionResultCard(
    originalUnit: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(modifier = Modifier.fillMaxWidth(0.8f)) {
            Text(text = "unit", fontSize = 12.sp)
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "converted number", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text(text = "converted unit", fontSize = 12.sp)
            }
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_carbon_bookmark_add),
                contentDescription = "Back"
            )
        }
    }

}