package com.rpsouza.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rpsouza.movies.presentation.screens.movieslist.MoviesListScreen

@Composable
fun AppHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.MoviesList
    ) {
        composable<AppRoutes.MoviesList> {
            MoviesListScreen()
        }
        composable<AppRoutes.MovieDetails> {
            // MovieDetailsScreen()
        }
    }
}