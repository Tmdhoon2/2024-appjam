package com.seunghoon.generator.navigation

sealed class NavigationRoute(val route: String) {
    data object Auth : NavigationRoute("auth") {
        val SPLASH = this.route + "/splash"
        val SIGN_IN = this.route + "/signIn"
    }

    data object Main : NavigationRoute("main") {
        val ROOT = this.route + "/root"
    }

    data object Root : NavigationRoute("root") {
        val RANKING = "${this.route}/ranking"
        val RECOMMEND = "${this.route}/recommend"
        val HOME = "${this.route}/home"
        val TAB2 = "${this.route}/tab2"
        val MY_PAGE = "${this.route}/myPage"
    }
}
