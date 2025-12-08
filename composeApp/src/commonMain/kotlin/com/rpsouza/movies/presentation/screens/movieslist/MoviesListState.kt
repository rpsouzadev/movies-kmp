package com.rpsouza.movies.presentation.screens.movieslist

import com.rpsouza.movies.domain.model.MovieSection

sealed interface MoviesListState {
    data object Loading : MoviesListState
    data class Success(val movieSections: List<MovieSection>) : MoviesListState
    data class Error(val message: String) : MoviesListState
}