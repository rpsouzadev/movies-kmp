package com.rpsouza.movies.presentation.screens.movieslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.rpsouza.movies.domain.model.MovieSection
import com.rpsouza.movies.presentation.components.moviesection.MovieSection
import com.rpsouza.movies.presentation.res.Dimens
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
fun MoviesListScreen(
    viewModel: MoviesListViewModel = koinInject()
) {
    val state = viewModel.moviesListState.collectAsState().value
    MoviesListContentScreen(moviesListState = state)
}

@Composable
private fun MoviesListContentScreen(
    moviesListState: MoviesListState
) {
    Scaffold() { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (moviesListState) {
                is MoviesListState.Loading -> MoviesListLoadingContent()
                is MoviesListState.Success -> MoviesListSuccessContent(moviesListState.movieSections)
                is MoviesListState.Error -> MoviesListErrorContent(moviesListState.message)
            }
        }
    }
}

@Composable
private fun MoviesListSuccessContent(
    movieSections: List<MovieSection>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.Dp16)
    ) {
        items(movieSections) {movieSection ->
            when(movieSection.sectionType) {
                MovieSection.SectionType.NOW_PLAYING -> {
                    MovieSection(
                        title = "Now Playing",
                        movies = movieSection.movies
                    )
                }
                MovieSection.SectionType.UPCOMING -> {
                    MovieSection(
                        title = "Upcoming",
                        movies = movieSection.movies
                    )
                }
                MovieSection.SectionType.POPULAR -> {
                    MovieSection(
                        title = "Popular",
                        movies = movieSection.movies
                    )
                }
                MovieSection.SectionType.TOP_RATED -> {
                    MovieSection(
                        title = "Top Rated",
                        movies = movieSection.movies
                    )
                }
            }
        }
    }
}

@Composable
private fun MoviesListErrorContent(
    message: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun MoviesListLoadingContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
        )
    }
}

@Preview
@Composable
private fun MoviesListPreview() {
    MoviesListContentScreen(
        moviesListState = MoviesListState.Success(movieSections = emptyList())
    )
}