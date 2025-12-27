package com.rpsouza.movies.presentation.components.castmemberitem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import coil3.compose.AsyncImage
import com.rpsouza.movies.presentation.theme.Dimens
import com.rpsouza.movies.presentation.theme.MoviesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CastMemberItem(
    modifier: Modifier = Modifier,
    profilePictureUrl: String?,
    name: String,
    character: String,
) {
    Surface(
        modifier = modifier
            .height(Dimens.Dp76),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = profilePictureUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(
                        MaterialTheme.shapes.medium.copy(
                            topEnd = ZeroCornerSize,
                            bottomEnd = ZeroCornerSize
                        )
                    ),
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.Dp16)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = character,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
private fun CastMemberItemPreview() {
    MoviesAppTheme {
        CastMemberItem(
            profilePictureUrl = "",
            name = "Will Smith",
            character = "Christopher Gardner",
        )
    }
}