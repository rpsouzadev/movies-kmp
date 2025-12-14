package com.rpsouza.movies.presentation.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rpsouza.movies.presentation.theme.Dimens
import com.rpsouza.movies.presentation.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.movie_details_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailsScreen() {
    MovieDetailsContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetailsContent() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(Res.string.movie_details_title))
                },
                navigationIcon = {
                    Surface(
                        modifier = Modifier
                            .padding(start = Dimens.Dp12),
                        shape = MaterialTheme.shapes.small,
                    ) {
                        IconButton(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(Dimens.Dp32)
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(Dimens.Dp8)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {

        }
    }
}

@Preview
@Composable
private fun MovieDetailsPreview() {
    MoviesAppTheme {
        MovieDetailsContent()
    }
}