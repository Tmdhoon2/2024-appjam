package com.seunghoon.generator.feature.mypage

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MyPageScree(modifier: Modifier = Modifier) {
    Column (modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()

                    settings.javaScriptEnabled = true

                    loadUrl("https://appjam.vercel.app/setting")
                }
            },
        )
    }
 }
