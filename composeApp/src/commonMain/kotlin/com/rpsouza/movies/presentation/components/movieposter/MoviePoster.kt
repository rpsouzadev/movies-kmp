package com.rpsouza.movies.presentation.components.movieposter

import androidx.compose.foundation.Image
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
import com.rpsouza.movies.domain.model.Movie
import com.rpsouza.movies.presentation.res.AppShapes
import com.rpsouza.movies.presentation.res.Dimens
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.minecraft
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    movie: Movie
) {
    Column(
        modifier = modifier
            .width(Dimens.Dp140)
    ) {
        Card(
            modifier = Modifier
                .width(Dimens.Dp140)
                .height(Dimens.Dp210),
            shape = AppShapes.medium
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.minecraft),
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
        movie = Movie.getFakeMovies().first()
    )
}