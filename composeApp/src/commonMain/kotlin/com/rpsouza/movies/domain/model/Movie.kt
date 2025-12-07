package com.rpsouza.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
) {
    companion object {
        fun getFakeMovies() = listOf(
            Movie(
                id = 1,
                title = "Movie 1",
                overview = "Overview 1",
                posterUrl = "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg"
            ),
            Movie(
                id = 2,
                title = "Movie 2",
                overview = "Overview 2",
                posterUrl = "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg"
            ),
            Movie(
                id = 3,
                title = "Movie 3",
                overview = "Overview 3",
                posterUrl = "https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg"
            )
        )
    }

}



