package com.example.unitconverter.ui.screens.conversion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputUI(
    inputNumber: MutableState<String>,
    inputUnit: MutableState<String>,
    unitList: List<String>,
    calculate: () -> (Unit),
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NumberInputField(inputNumber, modifier, calculate)
        UnitDropDownMenu(inputUnit, unitList, calculate, modifier)
    }
}

@Composable
fun NumberInputField(
    inputNumber: MutableState<String>,
    modifier: Modifier = Modifier,
    calculate: () -> (Unit)
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(0.65f),
        value = inputNumber.value,
        onValueChange = {
            inputNumber.value = it
            calculate()
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Number
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3F)
        ),
        textStyle = TextStyle(color = Color.DarkGray, fontSize = 16.sp)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UnitDropDownMenu(
    inputUnit: MutableState<String>,
    unitList: List<String>,
    calculate: () -> (Unit),
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    val expandIcon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            value = inputUnit.value,
            onValueChange = {
                inputUnit.value = it
                calculate()
            },
            readOnly = true,
            label = { Text(text = "unit") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            unitList.forEach { unit ->
                // menu item
                DropdownMenuItem(onClick = {
                    inputUnit.value = unit
                    expanded = false
                }) {
                    Text(text = unit)
                }
            }
        }
    }
}