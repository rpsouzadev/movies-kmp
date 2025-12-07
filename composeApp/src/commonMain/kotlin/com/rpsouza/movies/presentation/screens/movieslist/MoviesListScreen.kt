package com.rpsouza.movies.presentation.screens.movieslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rpsouza.movies.domain.model.Movie
import com.rpsouza.movies.presentation.components.moviesection.MovieSection
import com.rpsouza.movies.presentation.res.Dimens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviesListScreen() {
    MoviesListContentScreen()
}

@Composable
private fun MoviesListContentScreen() {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(Dimens.Dp16)
        ) {
            MovieSection(
                title = "Now Playing",
                movies = Movie.getFakeMovies()
            )

            MovieSection(
                title = "Now Playing",
                movies = Movie.getFakeMovies()
            )

            MovieSection(
                title = "Now Playing",
                movies = Movie.getFakeMovies()
            )

            MovieSection(
                title = "Now Playing",
                movies = Movie.getFakeMovies()
            )
        }
    }
}

@Preview
@Composable
private fun MoviesListPreview() {
    MoviesListContentScreen()
}