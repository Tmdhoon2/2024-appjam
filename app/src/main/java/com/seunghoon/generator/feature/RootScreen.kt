package com.seunghoon.generator.feature

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seunghoon.generator.component.BottomNavigationBar
import com.seunghoon.generator.feature.home.HomeScreen
import com.seunghoon.generator.navigation.NavigationRoute

@Composable
internal fun RootScreen(navHostController: NavHostController) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = NavigationRoute.Root.HOME,
        ) {
            composable(route = NavigationRoute.Root.TAB1) {

            }

            composable(route = NavigationRoute.Root.HOME) {
                HomeScreen(navHostController = navHostController)
            }

            composable(route = NavigationRoute.Root.TAB2) {

            }
        }
    }
}
