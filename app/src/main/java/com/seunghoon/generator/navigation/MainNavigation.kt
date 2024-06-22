package com.seunghoon.generator.navigation

import androidx.compose.material3.Scaffold
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.seunghoon.generator.feature.RootScreen

internal fun NavGraphBuilder.main(navHostController: NavHostController) {
    navigation(
        route = NavigationRoute.Main.route,
        startDestination = NavigationRoute.Root.route,
    ) {
        composable(route = NavigationRoute.Root.route) {
            RootScreen(navHostController = navHostController)
        }
    }
}
