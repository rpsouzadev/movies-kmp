package com.rpsouza.movies

class AndroidTokenProvider : TokenProvider {
    override val token: String = BuildKonfig.TMDB_API_KEY
}

actual suspend fun getAccessToken(): TokenProvider = AndroidTokenProvider()