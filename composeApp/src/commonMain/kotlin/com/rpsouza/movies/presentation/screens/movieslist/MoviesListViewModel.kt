package com.rpsouza.movies.presentation.screens.movieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rpsouza.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val moviesRepository: MoviesRepository
): ViewModel() {
    private val _moviesListState = MutableStateFlow<MoviesListState>(MoviesListState.Loading)
    val moviesListState = _moviesListState.asStateFlow()

    init {
        getMovieSections()
    }

    private fun getMovieSections() {
        viewModelScope.launch {
            try {
                val movieSections = moviesRepository.getMovies()
                _moviesListState.update {
                    MoviesListState.Success(movieSections)
                }
            } catch (e: Exception) {
                _moviesListState.update {
                    MoviesListState.Error(e.message ?: "Unknown error")
                }
            }
        }
    }
}