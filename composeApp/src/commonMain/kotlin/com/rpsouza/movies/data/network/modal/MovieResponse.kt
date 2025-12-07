package com.rpsouza.movies.data.network.modal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val id: Int,
    @SerialName("poster_path")
    val posterPath: String,
    val title: String,
    val overview: String,
)
