package com.baitent.habit_compose.data.source.remote

import io.ktor.client.HttpClient

class MainService(private val client: HttpClient) {
    companion object {
        private const val API_URL = "YOUR_API_URL"
    }
}