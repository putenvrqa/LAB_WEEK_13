package com.example.lab_week_13

import com.example.lab_week_13.api.MovieService
import com.example.lab_week_13.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.example.lab_week_13.database.MovieDatabase
import com.example.lab_week_13.database.MovieDao


class MovieRepository(private val movieService: MovieService,
    private val movieDatabase: MovieDatabase) {

    private val apiKey = "9e4b78023ccf118352e70d93fafc84d0"

    // fetch movies from the API
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            val movieDao: MovieDao = movieDatabase.movieDao()
            val savedMovies = movieDao.getMovies()

            if(savedMovies.isEmpty()) {
                val movies = movieService.getPopularMovies(apiKey).results
                movieDao.addMovies(movies)
                emit(movies)
            } else {
                emit(savedMovies)
            }
        }.flowOn(Dispatchers.IO)
    }
}