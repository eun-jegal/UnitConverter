package com.example.unitconverter.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.unitconverter.ui.screens.bookmark.BookmarksScreen
import com.example.unitconverter.ui.screens.conversion.ConversionScreen
import com.example.unitconverter.ui.screens.main.MainScreen
import com.example.unitconverter.ui.viewmodel.ConversionViewModel

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    viewModel: ConversionViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "main_screen",
        builder = {
            composable(route = "main_screen") {
                MainScreen(
                    onNavigateToConversionScreen = {
                        viewModel.updateConversionCategory(it)
                        navController.navigate("conversion_screen/$it")
                    },
                    onNavigateToBookmarkScreen = {
                        navController.navigate("bookmark_screen")
                    })
            }
            composable(
                route = "conversion_screen/{conversion_category}",
                arguments = listOf(
                    navArgument("conversion_category") {
                        type = NavType.StringType
                    }
                )
            ) {
                ConversionScreen(
                    category = it.arguments?.getString("conversion_category").toString(),
                    viewModel = viewModel,
                    onNavigateToMainScreen = {
                        navController.navigate("main_screen")
                    }
                )
            }
            composable(route = "bookmark_screen") {
                BookmarksScreen(
                    viewModel = viewModel,
                    onNavigateToMainScreen = {
                        navController.navigate("main_screen")
                    })
            }
        })
}