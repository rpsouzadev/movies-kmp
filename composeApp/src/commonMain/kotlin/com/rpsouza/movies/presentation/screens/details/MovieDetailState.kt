package com.rpsouza.movies.presentation.screens.details

import com.rpsouza.movies.domain.model.MovieDetails

sealed interface MovieDetailState {
    data object Loading : MovieDetailState
    data class Success(val movie: MovieDetails) : MovieDetailState
    data class Error(val message: String) : MovieDetailState
}