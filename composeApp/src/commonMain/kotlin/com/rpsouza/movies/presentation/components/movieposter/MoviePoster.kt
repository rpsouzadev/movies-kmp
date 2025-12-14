package com.rpsouza.movies.presentation.components.movieposter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import coil3.compose.AsyncImage
import com.rpsouza.movies.domain.model.Movie
import com.rpsouza.movies.presentation.theme.Dimens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: () -> Unit
) {
    Column(
        modifier = modifier
            .width(Dimens.Dp140)
            .clickable(onClick = onMovieClick)
    ) {
        Card(
            modifier = Modifier
                .width(Dimens.Dp140)
                .height(Dimens.Dp210),
            shape = MaterialTheme.shapes.small
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        movie = Movie(
            id = 1,
            title = "Movie Title",
            overview = "Movie Overview",
            posterUrl = "https://image"
        ),
        onMovieClick = {}
    )
}