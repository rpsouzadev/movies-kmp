package com.rpsouza.movies.data.repository

import com.rpsouza.movies.data.network.KtorClient
import com.rpsouza.movies.data.network.mapper.toDomain
import com.rpsouza.movies.domain.model.MovieSection
import com.rpsouza.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher,
    private val ktorClient: KtorClient
) : MoviesRepository {
    override suspend fun getMovies(): List<MovieSection> {
        return withContext(ioDispatcher) {
            val nowPlayingMoviesDeferred = async { ktorClient.getMovies("now_playing") }
            val popularMoviesDeferred = async { ktorClient.getMovies("popular") }
            val topRatedMoviesDeferred = async { ktorClient.getMovies("top_rated") }
            val upcomingMoviesDeferred = async { ktorClient.getMovies("upcoming") }

            val nowPlayingMovies = nowPlayingMoviesDeferred.await()
            val popularMovies = popularMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.NOW_PLAYING,
                    movies = nowPlayingMovies.results.map { it.toDomain() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = popularMovies.results.map { it.toDomain() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.TOP_RATED,
                    movies = topRatedMovies.results.map { it.toDomain() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.UPCOMING,
                    movies = upcomingMovies.results.map { it.toDomain() }
                )
            )
        }

    }
}