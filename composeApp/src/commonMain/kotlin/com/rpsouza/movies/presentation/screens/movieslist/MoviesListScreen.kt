package com.rpsouza.movies.presentation.screens.movieslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.rpsouza.movies.data.network.IMAGE_SMALL_BASE_URL
import com.rpsouza.movies.data.network.KtorClient
import com.rpsouza.movies.domain.model.Movie
import com.rpsouza.movies.presentation.components.moviesection.MovieSection
import com.rpsouza.movies.presentation.res.Dimens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviesListScreen() {
    var popularMovies by remember {
        mutableStateOf(emptyList<Movie>())
    }

    LaunchedEffect(Unit) {
        val response = KtorClient.getMovies("popular")
        popularMovies = response.results.map {
            Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                posterUrl = "$IMAGE_SMALL_BASE_URL${it.posterPath}",
            )
        }
    }

    MoviesListContentScreen(movies = popularMovies)
}

@Composable
private fun MoviesListContentScreen(
    movies: List<Movie> = emptyList()
) {
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
                movies = movies
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