package com.rpsouza.movies.domain.repository

import com.rpsouza.movies.domain.model.MovieDetails
import com.rpsouza.movies.domain.model.MovieSection

interface MoviesRepository {
    suspend fun getMovies(): List<MovieSection>
    suspend fun getMovieDetails(movieId: Int): Result<MovieDetails>
}