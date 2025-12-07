package com.rpsouza.movies.data.network.modal

import kotlinx.serialization.Serializable

@Serializable
data class MoviesListResponse(
    val results: List<MovieResponse>
)