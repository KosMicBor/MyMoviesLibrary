package gu_android_1032.mymovieslibrary.domain

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import gu_android_1032.mymovieslibrary.AppState
import gu_android_1032.mymovieslibrary.domain.responses.Movie
import java.util.concurrent.Executors

class GetMovieService : IntentService("GetMovieService") {
    companion object {
        const val ARG_MOVIE = "ARG_MOVIE"
        const val DEFAULT_MOVIE_ID = 0
        const val REQUEST_MOVIE_RESULT = "GetMovieService.REQUEST_MOVIE_RESULT"
        const val ARG_MOVIE_RESULT = "ARG_MOVIE_RESULT"

    }

    private val repository = MoviesRepositoryImpl()
    private val executor = Executors.newSingleThreadExecutor()

    override fun onHandleIntent(intent: Intent?) {
        val movieId = intent?.getIntExtra(ARG_MOVIE, DEFAULT_MOVIE_ID)

        repository.getMovie(executor, movieId) {

            when (it) {
                is AppState.Success -> {

                    Intent(REQUEST_MOVIE_RESULT).apply {
                        putExtra(ARG_MOVIE_RESULT, it.moviesData)
                    }.also {
                        LocalBroadcastManager.getInstance(this).sendBroadcast(it)
                    }

                }
                is AppState.Error -> {

                }
            }
        }

    }
}