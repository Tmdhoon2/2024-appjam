package com.seunghoon.generator.feature.signin

import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.seunghoon.generator.navigation.NavigationRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
internal fun SignInScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        AndroidView(
            factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()

                    settings.javaScriptEnabled = true

                    addJavascriptInterface(WebViewInterface(
                        navigateToMain = {
                            CoroutineScope(Dispatchers.Main).launch {
                                navController.navigate(NavigationRoute.Root.route)
                            }
                        }
                    ), "android")

                    loadUrl("https://appjam.vercel.app/login")
                }
            },
        )
    }
}

class WebViewInterface(
    private val navigateToMain: () -> Unit,
) {
    @JavascriptInterface
    fun getToken() {
        navigateToMain()
    }
}
