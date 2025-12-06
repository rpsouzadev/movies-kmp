package com.rpsouza.movies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform