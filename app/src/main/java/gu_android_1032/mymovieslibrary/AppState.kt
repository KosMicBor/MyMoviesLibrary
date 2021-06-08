package gu_android_1032.mymovieslibrary

sealed class AppState<T> {
    data class Success<T>(val moviesData: T) : AppState<T>()
    data class Error<T>(val error: Throwable) : AppState<T>()
}