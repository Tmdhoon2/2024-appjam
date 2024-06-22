package com.seunghoon.generator.navigation

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

internal fun NavGraphBuilder.auth() {
    navigation(
        route = NavigationRoute.Auth.route,
        startDestination = NavigationRoute.Auth.SPLASH,
    ) {
        composable(NavigationRoute.Auth.SPLASH) {

        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
internal fun WebViewTest() {
    Column(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()

                    settings.javaScriptEnabled = true

                    addJavascriptInterface(WebViewInterface(context), "android")

                    loadUrl("https://appjam.vercel.app")
                }
            },
        )
    }
}

class WebViewInterface(private val context: Context) {
    @JavascriptInterface
    fun getToken(json: String) {
        Toast.makeText(context, json, Toast.LENGTH_SHORT).show()
    }
}
