package gu_android_1032.mymovieslibrary

import gu_android_1032.mymovieslibrary.domain.Movie

sealed class AppState {
    data class Success(val moviesData: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}