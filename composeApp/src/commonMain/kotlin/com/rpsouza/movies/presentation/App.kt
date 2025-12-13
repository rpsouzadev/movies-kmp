package com.rpsouza.movies.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rpsouza.movies.di.dataModule
import com.rpsouza.movies.di.networkModule
import com.rpsouza.movies.di.viewModelModule
import com.rpsouza.movies.navigation.AppHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = { modules(networkModule, dataModule, viewModelModule) }
    ) {
        MaterialTheme {
            val navController = rememberNavController()
            AppHost(navController = navController)
        }
    }
}