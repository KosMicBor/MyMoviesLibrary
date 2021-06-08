package gu_android_1032.mymovieslibrary.domain

import android.os.Looper
import com.google.gson.Gson
import gu_android_1032.mymovieslibrary.AppState
import gu_android_1032.mymovieslibrary.BuildConfig
import gu_android_1032.mymovieslibrary.domain.responses.Movie
import gu_android_1032.mymovieslibrary.domain.responses.MovieDBLists
import java.lang.Exception
import java.net.URL
import java.util.concurrent.Executor
import javax.net.ssl.HttpsURLConnection

class MoviesRepositoryImpl : MoviesRepository {

    private val TIMEOUT_TIME_VALUE = 10_000

    private val mainHandler = android.os.Handler(Looper.getMainLooper())
    private val gson by lazy { Gson() }
    private lateinit var moviesList: List<Movie>

    override fun getMoviesList(
        executor: Executor,
        callback: (result: AppState<List<Movie>>) -> Unit
    ) {
        executor.execute {
            val url =
                URL("https://api.themoviedb.org/3/movie/popular?api_key=${BuildConfig.MOVIEDB_API_KEY}&language=en-US&page=1")
            val connection = url.openConnection() as HttpsURLConnection

            try {
                with(connection) {
                    requestMethod = "GET"
                    readTimeout = TIMEOUT_TIME_VALUE

                    val getListResponse =
                        gson.fromJson(inputStream.bufferedReader(), MovieDBLists::class.java)
                    moviesList = getListResponse.results

                    mainHandler.post { callback.invoke(AppState.Success(moviesList)) }
                }
            } catch (e: Exception) {
                callback.invoke(AppState.Error(e))
            } finally {
                connection.disconnect()
            }
        }
    }

    override fun getMovie(
        executor: Executor,
        movieId: Int?,
        callback: (result: AppState<Movie>) -> Unit
    ) {

        executor.execute {

            val url =
                URL("https://api.themoviedb.org/3/movie/${movieId}?api_key=${BuildConfig.MOVIEDB_API_KEY}&language=en-US")
            val connection = url.openConnection() as HttpsURLConnection

            try {
                with(connection) {
                    requestMethod = "GET"
                    readTimeout = TIMEOUT_TIME_VALUE

                    val getResponse =
                        gson.fromJson(inputStream.bufferedReader(), Movie::class.java)

                    mainHandler.post {
                        callback.invoke(AppState.Success(getResponse))
                    }
                }
            } catch (e: Exception) {
                callback.invoke(AppState.Error(e))
            } finally {
                connection.disconnect()
            }
        }
    }
}

