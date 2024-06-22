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
import com.seunghoon.generator.feature.feed.FeedScreen
import com.seunghoon.generator.feature.home.HomeScreen
import com.seunghoon.generator.feature.mypage.MyPageScree
import com.seunghoon.generator.feature.ranking.RankingScreen
import com.seunghoon.generator.feature.recommend.RecommendScreen
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
            composable(route = NavigationRoute.Root.RANKING) {
                RankingScreen(navController = navController)
            }
            composable(route = NavigationRoute.Root.RECOMMEND) {
                RecommendScreen(navController = navController)
            }

            composable(route = NavigationRoute.Root.HOME) {
                HomeScreen(
                    navHostController = navHostController,
                    navController = navController,
                )
            }

            composable(route = NavigationRoute.Root.TAB2) {
                FeedScreen()
            }

            composable(route = NavigationRoute.Root.MY_PAGE) {
                MyPageScree()
            }
        }
    }
}
