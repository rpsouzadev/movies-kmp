package com.rpsouza.movies.domain.model

data class MovieSection(
    val sectionType: SectionType,
    val movies: List<Movie>
) {
    enum class SectionType {
        NOW_PLAYING,
        UPCOMING,
        POPULAR,
        TOP_RATED
    }
}
