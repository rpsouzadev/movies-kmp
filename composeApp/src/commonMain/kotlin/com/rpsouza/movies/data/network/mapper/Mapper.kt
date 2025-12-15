package com.rpsouza.movies.data.network.mapper

import com.rpsouza.movies.data.network.IMAGE_SMALL_BASE_URL
import com.rpsouza.movies.data.network.modal.CastMemberResponse
import com.rpsouza.movies.data.network.modal.GenreResponse
import com.rpsouza.movies.data.network.modal.MovieDetailsResponse
import com.rpsouza.movies.data.network.modal.MovieResponse
import com.rpsouza.movies.domain.model.CastMember
import com.rpsouza.movies.domain.model.Genre
import com.rpsouza.movies.domain.model.Movie
import com.rpsouza.movies.domain.model.MovieDetails
import kotlin.math.roundToInt

fun MovieResponse.toDomain() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}"
)

fun CastMemberResponse.toDomain() = CastMember(
    id = this.id,
    mainRole = this.knownForDepartment,
    name = this.name,
    character = this.character,
    profilePath = "$IMAGE_SMALL_BASE_URL/${this.profilePath}",
)

fun GenreResponse.toDomain() = Genre(
    id = this.id,
    name = this.name,
)

fun MovieDetailsResponse.toDomain(castMembersResponse: List<CastMemberResponse>) = MovieDetails(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}",
    genres = this.genres.map { it.toDomain() },
    year = this.getYearFromReleaseDate(),
    duration = this.getDurationInHoursAndMinutes(),
    rating = "${this.voteAverage.roundToInt()}",
    castMembers = castMembersResponse
        .filter { it.knownForDepartment == "Acting" }
        .take(20)
        .map { it.toDomain() }
)

private fun MovieDetailsResponse.getYearFromReleaseDate(): Int {
    return this.releaseDate.year
}

private fun MovieDetailsResponse.getDurationInHoursAndMinutes(): String {
    return this.runtime.let { runtimeMinutes ->
        val hours = runtimeMinutes / 60
        val minutes = runtimeMinutes % 60

        buildString {
            if (hours > 0) {
                append("${hours}h:")
            }

            append("${minutes}min")
        }
    }
}