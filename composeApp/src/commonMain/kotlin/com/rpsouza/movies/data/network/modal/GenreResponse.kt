package com.rpsouza.movies.data.network.modal

import kotlinx.serialization.Serializable

@Serializable
class GenreResponse(
    val id: Int,
    val name: String
)