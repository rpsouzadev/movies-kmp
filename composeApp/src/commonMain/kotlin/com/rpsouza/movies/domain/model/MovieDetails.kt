package com.rpsouza.movies.domain.model

data class MovieDetails(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val genres: List<Genre>,
    val year: Int,
    val duration: String,
    val rating: String,
    val castMembers: List<CastMember>,
)

// fake objects
val movieDetails1 = MovieDetails(
    id = 1,
    title = "A Minecraft Movie",
    overview = "Movie overview",
    posterUrl = "url",
    genres = listOf(genre1, genre2),
    year = 2022,
    duration = "2h 36 min",
    rating = "8.5",
    castMembers = listOf(
        castMember1,
        castMember2,
    )
)