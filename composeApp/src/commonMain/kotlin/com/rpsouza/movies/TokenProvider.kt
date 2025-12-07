package com.rpsouza.movies

interface TokenProvider {
    val token: String
}

expect suspend fun getAccessToken(): TokenProvider