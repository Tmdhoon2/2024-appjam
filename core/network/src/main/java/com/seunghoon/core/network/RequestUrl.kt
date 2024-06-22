package com.seunghoon.core.network

sealed class RequestUrl(val path: String) {
    data object Auth: RequestUrl(path = "/auth") {
        val SIGN_UP = "$path/signup"
    }
}
