package com.rpsouza.movies.di


import com.rpsouza.movies.data.network.KtorClient
import com.rpsouza.movies.data.repository.MoviesRepositoryImpl
import com.rpsouza.movies.domain.repository.MoviesRepository
import com.rpsouza.movies.presentation.screens.movieslist.MoviesListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
}

val dataModule = module {
    factory<MoviesRepository> {
        MoviesRepositoryImpl(
            ioDispatcher = Dispatchers.IO,
            ktorClient = get()
        )
    }
}

val viewModelModule = module {
    viewModel { MoviesListViewModel(get()) }
}