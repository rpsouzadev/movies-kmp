package com.rpsouza.movies.presentation.components.genrechip

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rpsouza.movies.presentation.theme.Dimens
import com.rpsouza.movies.presentation.theme.MoviesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieGenreChip(
    modifier: Modifier = Modifier,
    genre: String
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = genre,
            modifier = Modifier.padding(horizontal = Dimens.Dp8),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
private fun MovieGenreChip() {
    MoviesAppTheme {
        MovieGenreChip(
            genre = "Action"
        )
    }
}