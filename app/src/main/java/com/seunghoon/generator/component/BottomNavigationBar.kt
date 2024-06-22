package com.seunghoon.generator.component

import androidx.annotation.DrawableRes
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.seunghoon.generator.R
import com.seunghoon.generator.navigation.NavigationRoute

private val menus = listOf(
    BottomMenu.Tab1,
    BottomMenu.Home,
    BottomMenu.Tab2,
)

sealed class BottomMenu(
    val route: String,
    @DrawableRes val iconRes: Int,
) {
    object Home : BottomMenu(
        route = NavigationRoute.Root.HOME,
        iconRes = R.drawable.ic_home,
    )

    object Tab1 : BottomMenu(
        route = NavigationRoute.Root.TAB1,
        iconRes = R.drawable.ic_icon1,
    )

    object Tab2 : BottomMenu(
        route = NavigationRoute.Root.TAB2,
        iconRes = R.drawable.ic_icon2,
    )
}

@Composable
internal fun BottomNavigationBar(navController: NavController) {
    BottomAppBar {
        menus.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        popUpTo(0) {
                            saveState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = null,
                    )
                },
            )
        }
    }
}
