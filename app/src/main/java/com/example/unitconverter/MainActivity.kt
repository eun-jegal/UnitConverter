package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.ViewModelProvider
import com.example.unitconverter.ui.screens.AppNavHost
import com.example.unitconverter.ui.screens.conversion.ConversionScreen
import com.example.unitconverter.ui.theme.UnitConverterTheme
import com.example.unitconverter.ui.viewmodel.ConversionViewModel
import com.example.unitconverter.ui.viewmodel.ConversionViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: ConversionViewModelFactory
    lateinit var viewModel: ConversionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as UnitConverterApp).appComponent.inject(this)
        viewModel = ViewModelProvider(this, factory)[ConversionViewModel::class.java]

        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.app_background)
                ) {
                    AppNavHost(viewModel = viewModel)
                }
            }
        }
    }
}