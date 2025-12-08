package com.rpsouza.movies.data.network.mapper

import com.rpsouza.movies.data.network.IMAGE_SMALL_BASE_URL
import com.rpsouza.movies.data.network.modal.MovieResponse
import com.rpsouza.movies.domain.model.Movie

fun MovieResponse.toDomain() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}"
)