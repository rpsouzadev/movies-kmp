package com.rpsouza.movies.presentation.components.moviesection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rpsouza.movies.domain.model.Movie
import com.rpsouza.movies.presentation.components.movieposter.MoviePoster
import com.rpsouza.movies.presentation.res.Dimens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieSection(
    title: String,
    movies: List<Movie>,
) {
    Column {
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = Dimens.Dp16, vertical = Dimens.Dp8),
            style = MaterialTheme.typography.titleLarge
        )

        LazyRow (
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = Dimens.Dp16),
            horizontalArrangement = Arrangement.spacedBy(Dimens.Dp16)
        ) {
            items(movies) { movie ->
                MoviePoster(movie = movie)
            }
        }
    }
}

@Preview
@Composable
private fun MovieSectionPreview() {
    MovieSection(
        title = "Movies",
        movies = emptyList()
    )
}