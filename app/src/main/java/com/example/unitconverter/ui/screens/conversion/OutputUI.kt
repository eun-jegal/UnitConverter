package com.example.unitconverter.ui.screens.conversion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.R
import com.example.unitconverter.data.db.ConversionResult

@Composable
fun OutputUI(
    inputNumber: MutableState<String>,
    inputUnit: MutableState<String>,
    resultList: State<List<Pair<String, String>>>,
    onClickSave: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = resultList.value) { result ->
            ConversionResultCard(
                inputNumber = inputNumber.value,
                inputUnit = inputUnit.value,
                outputNumber = result.first,
                outputUnit = result.second,
                onClickSave = onClickSave,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ConversionResultCard(
    inputNumber: String,
    inputUnit: String,
    outputNumber: String,
    outputUnit: String,
    onClickSave: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
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
        Column(modifier = Modifier.fillMaxWidth(0.8f)) {
            Text(text = outputUnit, fontSize = 14.sp)
            Spacer(modifier = modifier.height(2.dp))
            Text(text = outputNumber, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }
        IconButton(
            onClick = {
                onClickSave(
                    ConversionResult(
                        inputNumber = inputNumber,
                        inputUnit = inputUnit,
                        outputNumber = outputNumber,
                        outputUnit = outputUnit
                    )
                )
            },
            modifier = modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_carbon_bookmark_add),
                contentDescription = "Back"
            )
        }
    }

}