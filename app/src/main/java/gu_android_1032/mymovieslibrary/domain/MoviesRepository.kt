package gu_android_1032.mymovieslibrary.domain

import gu_android_1032.mymovieslibrary.AppState
import gu_android_1032.mymovieslibrary.domain.responses.Movie
import java.util.concurrent.Executor

interface MoviesRepository {
    fun getMoviesList(executor: Executor, callback: (result: AppState<List<Movie>>) -> Unit)
    fun getMovie(executor: Executor, movieId: Int?, callback: (result: AppState<Movie>) -> Unit)
}