package com.seunghoon.core.network

import com.seunghoon.bidding_android.data.util.RequestHandler
import io.ktor.client.request.post
import io.ktor.client.request.url

class AuthApi {
    suspend fun signUp() = with(KtorClient.client) {
        RequestHandler<Unit>().request {
            post {
                url(RequestUrl.Auth.SIGN_UP)
            }
        }
    }
}
