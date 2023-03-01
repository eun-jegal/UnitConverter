package com.example.unitconverter.ui.screens.conversion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun InputUI(
    inputNumber: MutableState<String>,
    inputUnit: MutableState<String>,
    unitList: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NumberInputField(inputNumber, modifier)
        UnitDropDownMenu(inputUnit, unitList, modifier)
    }
}

@Composable
fun NumberInputField(
    inputNumber: MutableState<String>,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(0.65f)
            .fillMaxHeight(),
        value = inputNumber.value,
        onValueChange = {
            inputNumber.value = it
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

@Composable
fun UnitDropDownMenu(
    inputUnit: MutableState<String>,
    unitList: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var dropdownMenuTextSize by remember { mutableStateOf(Size.Zero) }
    var selectedUnit by rememberSaveable { inputUnit }

    val expandIcon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    Column(
        modifier = modifier
            .fillMaxWidth(0.3f)
            .fillMaxHeight()
    ) {
        OutlinedTextField(
            value = selectedUnit,
            onValueChange = { selectedUnit = it },
            textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    dropdownMenuTextSize = coordinates.size.toSize()
                },
            label = { Text(text = "Conversion type") },
            trailingIcon = {
                Icon(expandIcon, contentDescription = "expand",
                    modifier.clickable { expanded = !expanded })
            },
            readOnly = true
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier.width(with(LocalDensity.current) { dropdownMenuTextSize.width.toDp() })
        )
        {
            unitList.forEach { unit ->
                DropdownMenuItem(onClick = {
                    selectedUnit = unit
                    expanded = false
                }) {
                    Text(
                        text = unit,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}