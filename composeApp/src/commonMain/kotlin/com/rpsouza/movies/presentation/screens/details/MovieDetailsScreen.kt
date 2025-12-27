package com.rpsouza.movies.presentation.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.rpsouza.movies.domain.model.MovieDetails
import com.rpsouza.movies.domain.model.movieDetails1
import com.rpsouza.movies.presentation.components.castmemberitem.CastMemberItem
import com.rpsouza.movies.presentation.components.genrechip.MovieGenreChip
import com.rpsouza.movies.presentation.components.movieinfoitem.MovieInfoItem
import com.rpsouza.movies.presentation.theme.Dimens
import com.rpsouza.movies.presentation.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.Calendar
import compose.icons.fontawesomeicons.solid.Clock
import compose.icons.fontawesomeicons.solid.Play
import compose.icons.fontawesomeicons.solid.Star
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.movie_details_title
import movies.composeapp.generated.resources.movie_details_watch_trailer
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailViewModel = koinViewModel(),
    popBackStack: () -> Unit
) {
    val movieDetailState by viewModel.movieDetailState.collectAsStateWithLifecycle()
    MovieDetailsContent(
        movieDetailState = movieDetailState,
        popBackStack = popBackStack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetailsContent(
    movieDetailState: MovieDetailState,
    popBackStack: () -> Unit
) {
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
                            onClick = popBackStack,
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
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            when (movieDetailState) {
                is MovieDetailState.Loading -> {
                    CircularProgressIndicator()
                }
                is MovieDetailState.Success -> {
                    MoviesDetailsSuccess(
                        movie = movieDetailState.movie
                    )
                }
                is MovieDetailState.Error -> {
                    Text(
                        text = movieDetailState.message,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error,
                    )
                }
            }
        }
    }


}

@Composable
private fun MoviesDetailsSuccess(
    movie: MovieDetails,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(Dimens.Dp16)
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = Dimens.Dp4)
                .weight(1f),
            shape = MaterialTheme.shapes.large,
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.Dp8)
        ) {
            Text(
                text = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.Dp16),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Dimens.Dp16)
            ) {
                MovieInfoItem(
                    icon = FontAwesomeIcons.Solid.Star,
                    text = movie.rating
                )

                MovieInfoItem(
                    icon = FontAwesomeIcons.Solid.Clock,
                    text = movie.duration
                )

                MovieInfoItem(
                    icon = FontAwesomeIcons.Solid.Calendar,
                    text = movie.year.toString()
                )
            }

            LazyRow(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Dimens.Dp8),
            ) {
                items(movie.genres) { genre ->
                    MovieGenreChip(
                        genre = genre.name
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(Dimens.Dp16)
            ) {
                ElevatedButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.Dp16),
                ) {
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.Play,
                        contentDescription = null,
                        modifier = Modifier
                            .size(Dimens.Dp12)
                    )

                    Text(
                        text = stringResource(Res.string.movie_details_watch_trailer),
                        modifier = Modifier
                            .padding(start = Dimens.Dp16),
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    BoxWithConstraints {
                        val itemWidth = this.maxWidth * 0.55f

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = Dimens.Dp16),
                            horizontalArrangement = Arrangement.spacedBy(Dimens.Dp16),
                        ) {
                            items(movie.castMembers) { cast ->
                                CastMemberItem(
                                    profilePictureUrl = cast.profilePath,
                                    name = cast.name,
                                    character = cast.character,
                                    modifier = Modifier
                                        .width(itemWidth)
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .padding(Dimens.Dp16)
                    ) {
                        Text(
                            text = movie.overview,
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MovieDetailsPreview() {
    MoviesAppTheme {
        MovieDetailsContent(
            movieDetailState = MovieDetailState.Success(movieDetails1),
            popBackStack = {}
        )
    }
}