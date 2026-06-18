package com.example.square

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(){
    val navController=rememberNavController()

    NavHost(
        navController=navController,
        startDestination = "table"
    ){
        composable("table"){
            TableScreen(
                onNavigateToCalc={navController.navigate("calc")}
            )
        }
        composable("calc"){
            FactScreen(
                onBack={
                    navController.popBackStack()
                },
                onNext={
                    navController.navigate("screenC")
                }
            )
        }
        composable("screenC"){
            ScreenC(
                onBack={
                    navController.popBackStack()
                }
            )
        }
    }
}