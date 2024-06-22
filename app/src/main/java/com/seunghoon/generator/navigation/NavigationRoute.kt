package com.seunghoon.generator.navigation

sealed class NavigationRoute(val route: String) {
    data object Auth : NavigationRoute("auth") {
        val SPLASH = this.route + "/splash"
    }

    data object Main : NavigationRoute("main") {
        val ROOT = this.route + "/root"
    }

    data object Root : NavigationRoute("root") {
        val TAB1 = "${this.route}/tab1"
        val HOME = "${this.route}/home"
        val TAB2 = "${this.route}/tab2"
    }
}
