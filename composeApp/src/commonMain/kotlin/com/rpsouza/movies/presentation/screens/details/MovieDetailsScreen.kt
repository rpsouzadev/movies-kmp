package com.rpsouza.movies.presentation.screens.details

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.rpsouza.movies.domain.model.Movie
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
import movies.composeapp.generated.resources.minecraft
import movies.composeapp.generated.resources.movie_details_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailsScreen() {
    MovieDetailsContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetailsContent(movie: Movie) {
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
            verticalArrangement = Arrangement.spacedBy(Dimens.Dp16)
        ) {
            Card(
                modifier = Modifier
                    .padding(Dimens.Dp16)
                    .weight(1f),
                shape = MaterialTheme.shapes.large,
            ) {
                Image(
                    painter = painterResource(Res.drawable.minecraft),
                    contentDescription = null,
                    modifier = Modifier
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
                        text = "7.5"
                    )

                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Clock,
                        text = "2h 36 min"
                    )

                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Calendar,
                        text = "2022"
                    )
                }

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MovieGenreChip(
                        genre = "Action"
                    )
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
                            text = "Watch trailer",
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
                                items(10) {
                                    CastMemberItem(
                                        profilePictureUrl = "",
                                        name = "Will Smith",
                                        character = "Christopher Gardner",
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
                                text = "Trying to leave their troubled lives behind, twin brothers return to their hometown to start again, only to discover that an even greater evil is waiting to welcome them back.",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
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
            movie = Movie(
                id = 1,
                title = "The Shawshank Redemption",
                overview = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                posterUrl = ""
            )
        )
    }
}