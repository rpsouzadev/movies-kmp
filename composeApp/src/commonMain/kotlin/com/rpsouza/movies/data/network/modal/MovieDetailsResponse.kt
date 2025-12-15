package com.rpsouza.movies.data.network.modal

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieDetailsResponse(
    val id: Int,
    @SerialName("poster_path")
    val posterPath: String,
    val title: String,
    val overview: String,
    val genres: List<GenreResponse>,
    @SerialName("release_date")
    val releaseDate: LocalDate,
    val runtime: Int,
    @SerialName("vote_average")
    val voteAverage: Double
)