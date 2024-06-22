package com.seunghoon.generator.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
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
        route = NavigationRoute.Root.RECOMMEND,
        iconRes = R.drawable.ic_icon1,
    )

    object Tab2 : BottomMenu(
        route = NavigationRoute.Root.TAB2,
        iconRes = R.drawable.ic_icon2,
    )
}

@Composable
internal fun BottomNavigationBar(navController: NavController) {
    val selectedRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    BottomAppBar(
        modifier = Modifier.shadow(
            elevation = 8.dp,
        ),
        containerColor = Color.White,
    ) {
        menus.forEach { item ->
            val selected = selectedRoute == item.route
            val color by animateColorAsState(
                targetValue = if (selected) Color(0xFFEE3B3B)
                else Color(0xFFD9D9D9),
                label = "",
            )
            NavigationBarItem(
                selected = selected,
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
                        tint = color,
                        painter = painterResource(id = item.iconRes),
                        contentDescription = null,
                    )
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White),
            )
        }
    }
}
