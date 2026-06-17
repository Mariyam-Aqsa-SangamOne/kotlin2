package com.example.a1a

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "catScreen"
    ) {
        composable("catScreen") {
            CatScreen(navController = navController)
        }
        composable("catDogScreen") {
            CatandDogScreen(navController = navController)
        }
        composable("CowAndElephant") {
            CowAndElephant(navController = navController)
        }
        composable("GalleryScreen") {
            GalleryScreen(navController = navController)
        }
        composable("ScreenD") {
            ScreenD(navController = navController)
        }
    }
}